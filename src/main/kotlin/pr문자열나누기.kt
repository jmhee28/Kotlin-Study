class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var str = s
        while(str.length > 0) {
            str = getStr(str)
            answer++
        }
        return answer
    }

    fun getStr(s: String): String {
        var x = s[0]
        var xcnt = 1
        var ncnt = 0
        var stopIdx = 0
        for(i in 1 until s.length){
            if(s[i] == x){
                xcnt++
            } else{
                ncnt++
            }
            if(xcnt == ncnt){
                stopIdx = i
                break
            }
        }
        var retStr = s.drop(stopIdx+1)
        return retStr
    }
}
fun main(){
    var s = readln()
    var sol = Solution()
    println( sol.solution(s))
}