var cnt = 0
fun solution(a: Int, b: Int, n: Int): Int {
    // var answer: Int = 0
    getCnt(a, b, n)
    return cnt
}

fun getCnt(a: Int, b: Int, n: Int){
    if(n < a){
        return
    }
    var cola = (n/ a).toInt() * b
    cnt += cola
    var nn = cola + (n % a)
    getCnt(a, b, nn)
}

fun main(){
    println(solution(2,1,20))
}
