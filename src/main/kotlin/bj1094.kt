fun main() {
    val number = 16 shr 3

    val binaryString = Integer.toBinaryString(number) // 이진수 문자열로 변환
    println(binaryString)
//    println(binaryString.count{it == '1'})
}
