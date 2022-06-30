import java.lang.Math.abs

fun main(){
    val size = readLine()!!
    val str = readLine()!!.toString()
    val list = mutableListOf<Char>()
    for (el in 0..size.length){
        var ee = str.get(el)
        list.add(ee)
    }
    val numbersArray = readLine()!!.split(" ").map { it.toInt() }
    println(charSearch(list, numbersArray))
}

fun charSearch(mutableList: MutableList<Char>, res: List<Int>): Char {
    val arrayNumber = arrayListOf<Int>()
    for (el in 0 until res.size - 1) {
        arrayNumber.add(abs(res[el] - res[el + 1]))
    }
    val index = arrayNumber.lastIndexOf(arrayNumber.maxOrNull()) + 1
    val char: Char = mutableList[index]
    return char
}