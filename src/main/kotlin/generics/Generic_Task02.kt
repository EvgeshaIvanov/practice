package generics

fun main() {

}

data class Pair<V1, V2>(private val value1: V1, private val value2: V2) {

    fun getFirstValue(): V1 {
        return value1
    }

    fun getSecondValue(): V2 {
        return value2
    }

}

class OtherPair<V1>(val value1: V1, private val value2: V1) {

    fun getFirstValue(): V1 {
        return value1
    }

    fun getSecondValue(): V1 {
        return value2
    }

}