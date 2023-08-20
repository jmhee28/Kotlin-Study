// 오 왼 아래 위 순
class Robot{
    var dx = arrayOf(0, 0, 1, -1)
    var dy = arrayOf(1, -1, 0, 0)
    lateinit var pDir: DoubleArray
    lateinit var board: MutableList<MutableList<Int>>
    var rc = 0
    var maxN =0
    var answer = 0.0
    var zeroCnt = 0
    var nonZeroPer = 0.0
    fun solution(){
        var (N, e, w, s, n) = readln().split(" ").map{it.toInt()}
        maxN = N
        pDir = arrayOf(e, w, s, n).map{
            if(it == 0){
            zeroCnt++
            }
            it.toDouble() /100.0
        }.toDoubleArray()

        rc = N * 2 + 2
        board = MutableList(rc){ MutableList(rc){0}}
        var x = (N / 2).toInt() + 1
        var y = (N / 2).toInt() + 1
        board[x][y] = 1
        nonZeroPer = zeroCnt.toDouble() / 4.0

        bfs(x, y, board, 0, 1.0)
        println(1.0 - answer)
    }

    fun bfs(x: Int, y: Int, board: MutableList<MutableList<Int>>, cnt:Int, pos: Double) {
        if(cnt == maxN){
            return
        }
        for(i in 0 until 4 ){
            var nx = x + dx[i]
            var ny = y + dy[i]
            if(nx in 0 until rc && ny in 0 until rc){
                if(board[nx][ny] == 0){
                    board[nx][ny] = 1
                    bfs(nx, ny, board, cnt+1, pos * pDir[i])
                    board[nx][ny] = 0
                }else{
                    var t =  Math.pow(nonZeroPer, (maxN-(cnt)).toDouble())
                    if(t > 0.0){
                        answer += pos * pDir[i] * t
                    }else{
                        answer += pos * pDir[i]
                    }

                }
            }
        }
    }
}

fun main() {
    var S = Robot()
    S.solution()
}