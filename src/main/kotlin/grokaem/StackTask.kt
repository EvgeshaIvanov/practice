package grokaem

fun main() {

    println(fact(5))

}

fun fact(x: Int): Int {
    return if (x == 1) {
        1
    } else {
        x * fact(x - 1)
    }
}

fun greet(name: String) {
    println("Hello, $name")
    greet2(name)
    println("getting ready to say bye...")
    bye()
}


fun greet2(name: String) {
    println("How are u, $name?")
}

fun bye() {
    println("ok bye")
}