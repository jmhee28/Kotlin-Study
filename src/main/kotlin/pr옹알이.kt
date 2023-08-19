import java.util.Stack
class olalry {
    var voca = mutableMapOf<Char, String>()
    var vocaChars = mutableListOf<Char>()
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        voca['a'] = "aya"
        voca['y'] = "ye"
        voca['w'] = "woo"
        voca['m'] = "ma"
        vocaChars = voca.keys.toMutableList()

        babbling.forEach {it->
            if(pronounceYn(it)){
                answer++
            }
        }
        return answer
    }

    fun pronounceYn(str: String):Boolean{
        var k = str[0]
        if(k in vocaChars){
            var ssize = str.length
            if(ssize == voca[k]!!.length ){
                if(str == voca[k]){
                    return true
                }
               return false
            } else if (ssize < voca[k]!!.length){
                return false
            } else {
                return exceedStr(str)
            }
        }
        return false
    }

    fun exceedStr(str: String): Boolean{
        var k = str[0]
        var kstr = voca[k]
        var klength = kstr!!.length

        var stack = mutableListOf<Char>()
        for (i in 0 .. str.length){
            if(stack.size == klength){
                if(stack.joinToString("") != kstr){
                    return false
                } else {
                    if(k == str[i]) {
                        return false
                    }
                    stack = mutableListOf<Char>()
                    k = str[i]
                    if (k in vocaChars){
                        kstr = voca[k]
                        klength = kstr!!.length
                    } else{
                        return false
                    }
                }
            }
            if(i < str.length){
                stack.add(str[i])
            }

        }
        if(stack.size > 0){
            return false
        }
        return true
    }
}

fun main(){
    var sol = olalry()
    println( sol.solution(arrayOf("ayayewoomauuuuu")))
}