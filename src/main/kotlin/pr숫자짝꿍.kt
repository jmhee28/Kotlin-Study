class Sut {
    fun solution(X: String, Y: String): String {
        var answer = ""
        var xlist = X.toMutableList()
        var ylist = Y.toMutableList()
        var common = mutableListOf<Char>()
        if(xlist.size < ylist.size){
            common = getCom(xlist, ylist)
        }else{
            common = getCom(ylist, xlist)
        }

        if(common.size == 0){
            return "-1"
        } else if (common.size == 1){
            answer = common[0].toString()
        } else{
            answer = getBig(common)
        }

        return answer.toInt().toString()
    }
    fun getCom(a: MutableList<Char>, b: MutableList<Char>) : MutableList<Char>{
        var common = mutableListOf<Char>()
        a.forEach{ it->
            val indexInB = b.indexOf(it)
            if (indexInB != -1) { // -1은 찾지 못한 경우를 나타냅니다.
                common.add(it)
                b.removeAt(indexInB)
            }

        }
        return common
    }

    fun getBig(common: MutableList<Char>): String{
        var ret = 0
        common.sortDescending()
        return common.joinToString("")
    }
}