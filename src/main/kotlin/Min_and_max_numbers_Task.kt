fun main() {

//    for (el in 1..100) {
//        if (el % 3 == 0 && el % 5 == 0) {
//            println("ФИЗБАЗ")
//        }
//        else if (el %3 ==0){
//            println("ФИЗ")
//        }
//        else if (el %5 ==0 ){
//            println("БАЗ")
//        }
//        else println(el)
//    }

    //два максимальных числа
    val list = listOf(1, 100, 10000, 23, 18)
    var firstMax = list[0]
    var secondMax = list[0]

    for (el in list) {
        if (el > firstMax) {
            secondMax = firstMax
            firstMax = el
        } else if (el > secondMax) {
            secondMax = el
        }
    }
    println("1-ый $firstMax, 2-ой $secondMax")

    //Два минимальных числа
    val listOfMin = listOf(10, 2, 50, 4, 10, 1)
    var firstMin = listOfMin[0]
    var secondMin = listOfMin[0]
    for (el in listOfMin) {
        if (el < firstMin) {
            secondMin = firstMin
            firstMin = el
        } else if (el < secondMin) {
            secondMin = el
        }
    }

    println("Первый - $firstMin, Второй - $secondMin")
}
