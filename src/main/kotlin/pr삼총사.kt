class Sam {
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        var combs = mutableListOf<List<Int>>()
        combination(combs, number.toList(), Array<Boolean>(number.size){ false}, 0, 3)
        combs.forEach { it ->
            if (it.sum() == 0)
                answer++
        }
        return answer
    }

    fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target:Int){
        if(target == 0){
            answer.addAll(listOf(el.filterIndexed {index, t -> ck[index]}))
        }else {
            for(i in start until el.size){
                ck[i] = true
                combination(answer, el, ck, i+1, target-1)
                ck[i] = false
            }
        }
    }
}