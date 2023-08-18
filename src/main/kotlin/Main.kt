fun main(args: Array<String>) {
    println("Hello World!")
    //val a = readLine()!!.toInt() //!! 는 널 아님 단언(not-null assertion)으로, readLine()의 결과가 널(null) 일 경우 예외를 발생 시킨다.
    val size = readLine()!!.toInt()
    val squares = Array(size) { (it + 1)*(it + 1) }

    println(squares)
}