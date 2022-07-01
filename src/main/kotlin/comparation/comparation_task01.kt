package comparation

import java.util.*
import kotlin.Comparator

fun main() {

    val employee1 = Employee(100, "Zaur", "Ivanov", 50_000)
    val employee2 = Employee(15, "Ivan", "Petrov", 150_000)
    val employee3 = Employee(230, "Ivan", "Malkov", 250_000)
    val list = listOf(employee1, employee2, employee3)
    println("Before sorting $list")
    println(list.sorted())
    println(list.sortedWith(NameComparator()))
    println(list.sortedWith(SalaryComparator()))

}

class Employee(val id: Int, val name: String, val surName: String, val salary: Int): Comparable<Employee> {
    override fun toString(): String {
        return "Employee {id = $id, name = $name, surname = $surName, salary = $salary}"
    }

    override fun compareTo(other: Employee): Int {
////        1 способ
//        return if (this.id == other.id) 0
//        else if (this.id < other.id) -1
//        else 1
//        2 способ
        return this.id - other.id
//        3 способ
//        return this.id.compareTo(other.id)
//        var result = this.name.compareTo(other.name)
//        if (result == 0) {
//            result = this.surName.compareTo(other.surName)
//        }
//        return result
    }
}
//
//class IdComparator : Comparator<Employee> {
//    override fun compare(e1: Employee, e2: Employee): Int {
//        return if (e1.id == e2.id) 0
//        else if (e1.id < e2.id) -1
//        else 1
//    }
//}

class NameComparator : Comparator<Employee> {
    override fun compare(e1: Employee, e2: Employee): Int {
        return e1.name.compareTo(e2.name)
    }
}

class SalaryComparator : Comparator<Employee> {
    override fun compare(e1: Employee, e2: Employee): Int {
        return e1.salary - e2.salary
    }
}
