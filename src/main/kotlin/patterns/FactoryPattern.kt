package patterns

fun main() {

    val firstTechnologies: List<Technology> = listOf(Technology.ROOM)
    val secondTechnologies: List<Technology> = listOf(Technology.ROOM, Technology.CICERONE)
    val thirdTechnologies: List<Technology> = listOf(Technology.ROOM, Technology.SQLITE, Technology.DAGGER)

    val employeeFactory = EmployeeFactory()
    println(employeeFactory.create(firstTechnologies))
    println(employeeFactory.create(secondTechnologies))
    println(employeeFactory.create(thirdTechnologies))

}


abstract class Employee(val salary: Int, val experience: Int, val stack: List<Technology>) {

}

class Junior(salary: Int, experience: Int, stack: List<Technology>) : Employee(salary, experience, stack) {
    override fun toString(): String {
        return "Junior - $salary, $experience, $stack"
    }
}

class Middle(salary: Int, experience: Int, stack: List<Technology>) : Employee(salary, experience, stack) {
    override fun toString(): String {
        return "Middle - $salary, $experience, $stack"
    }
}

class Senior(salary: Int, experience: Int, stack: List<Technology>) : Employee(salary, experience, stack) {
    override fun toString(): String {
        return "Senior - $salary, $experience, $stack"
    }
}

class EmployeeFactory {
    fun create(list: List<Technology>): Employee {
        return when (list.size) {
            1 -> Junior(30000, 1, list)
            2 -> Middle(60000, 2, list)
            3 -> Senior(130000, 3, list)
            else -> throw IllegalArgumentException("Квалификации с таким стэком не существует")
        }
    }
}

enum class Technology {
    ROOM, SQLITE, CICERONE, DAGGER
}
