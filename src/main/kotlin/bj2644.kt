class Family{
    lateinit var fam:MutableList<MutableList<Int>>
    var answer = -1
    var target = 0
    fun solution(){
        var n = readln().toInt()
        var (perA, perB) = readln().split(" ").map{
            it.toInt()
        }
        fam = MutableList(n+1){ mutableListOf<Int>() }
        var m = readln().toInt()
        for(i in 0 until m){
            var (parent, child) = readln().split(" ").map {
                it.toInt()
            }
            fam[parent].add(child)
            fam[child].add(parent)
        }
        var visited = MutableList(n+1){false}
        visited[perA] = true
        target = perB
        dfs(perA, visited, 0)
        print(answer)
    }

    fun dfs(x: Int, visited: MutableList<Boolean>, cnt: Int){
        if(x == target){
            answer = cnt
            return
        }
        for(i in fam[x]){
            if(!visited[i]){
                visited[i] = true
                dfs(i, visited, cnt+1)
                visited[i] = false
            }
        }
    }
}
fun main(){
    var S = Family()
    S.solution()
}