package generics

fun main() {

    val info = Info<Int>(21312)
    println(info)
    val s = info.getValue()
    val info2 = Info<String>("dwad")
    val y = info2.getValue()
    println(info2)

}


class Info<T>(private val value: T) {
    override fun toString(): String {
        return "{[$value]}"
    }

    fun getValue(): T {
        return value
    }
}
