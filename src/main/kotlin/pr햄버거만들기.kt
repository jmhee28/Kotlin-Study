class Ham {
    var hamburger = arrayOf(1, 2, 3, 1)
    var cnt = 0
    fun solution(ingredient: IntArray): Int {
        getHamburgers(ingredient)
        return cnt
    }

   fun getHamburgers(ingArr: IntArray) {

       if(ingArr.size < 4){
           return
       }

       for(i in 0 until ingArr.size - 3){
           var sliced = ingArr.sliceArray(i until i+4)
           if(hamburger.contentEquals(sliced.toTypedArray())){
               cnt++
               var arr1 = ingArr.sliceArray(0..i-1)
               var end = ingArr.size
               var arr2 = ingArr.sliceArray(i+4..end-1)
               var nArr = arr1 + arr2
               return getHamburgers(nArr)
           }
       }
   }
}

fun main(){
    var sol = Ham()
    println( sol.solution(arrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1).toIntArray()))
}