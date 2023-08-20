class Sut {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        var x = Array<Int>(10){0}
        var y = Array<Int>(10){0}

        for(i in 0 until X.length){
            x[X[i]-'0']++
        }
        for(i in 0 until Y.length){
            x[Y[i]-'0']++
        }
        for(i in 9 downTo 0){
            for(j in 0 until Math.min(x[i], y[i])){
                answer += ('0' + i)
            }
        }
        if(answer == ""){
            answer = "-1"
        }
        if(answer[0] == '0'){
            return "0"
        }
        return answer
    }
}