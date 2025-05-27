fun main() {
    val msg: String = greet()

    val sum: Int = addNumbers(20, 30)
    val sum2: Int = addNumbers(20, 30, 50)
    println(sum2)
}

fun greet(): String {
    return "Hello Kotlin"
}

fun addNumbers(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun addNumbers(num1: Int, num2: Int, num3: Int): Int {
    return num1 + num2 + num3
}