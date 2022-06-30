fun main() {
    val n = readLine()!!.toInt()
    val list = MutableList(n){ readLine()!!.toString() }


    println(checkMail(list))
}

fun checkMail(list: List<String>): Int {
    var login: String
    var domain: String
    val domSet = mutableSetOf<String>()
    list.forEach { str ->
        login = str.substringBefore('@').replace(".", "").substringBefore('-')
        domain = str.substringAfter('@').substringBeforeLast('.')
        domSet.add("$login@$domain")
    }
    return domSet.size
}


