fun main() {
//    val car: Car = Car("Honda", "Vezel")
//    val car2: Car = Car("Suzuki", "Wagon-R", 2025)

    val dog: Dog = Dog("Black")
    dog.eat()
    println(dog.weight)
}

class Car (val make: String, val model: String) {

    init {
        println("The car is ${this.make} ${this.model}")
    }

    constructor(make: String, model: String, year: Int): this(make, model) {
        println("Secondary Constructor Called: The car is ${this.make} ${this.model} ${year}")
    }
}

open class Animal(val color: String) {
    open var weight: Double = 0.0
    var serialNumber: String = "56hgxw923qo2"
        get() = field.uppercase()
        set(value) {
            field = value.plus("__")
        }

    init {
        this.serialNumber = "872ckdjhew23"
        println("Serial Number: ${this.serialNumber}")
    }

    open fun eat() {
        println("The animal is eating..")
    }
}

class Dog(color: String): Animal(color) {
    init {
        super.weight = 20.5
        println(this.color)
    }

    override fun eat() {
        println("The dog is eating...")
    }
}

abstract class Employee {
    abstract fun getBasicInfo()
    abstract fun calculateSalary()
    abstract fun getBankDetails()
}

class NormalEmployee(): Employee() {
    override fun getBasicInfo() {

    }

    override fun calculateSalary() {

    }

    override  fun getBankDetails() {

    }
}

interface Student {
    fun getStudentInfo()
    fun getCourseInfo()
    fun getFeeInfo()
}

class CollegeStudent: Student {
    override fun getStudentInfo() {

    }

    override fun  getCourseInfo() {

    }

    override fun getFeeInfo() {

    }
}