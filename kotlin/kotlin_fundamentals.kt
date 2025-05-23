fun main() {
    val name: String = "John Doe"
    val age: Int = 24
    val pi: Double = 3.14
    val grade: Char = 'A'
    val isActive: Boolean = false

    val users: Array<String?> = arrayOf("John", "Sara", null, "Mike")

    println("User: ${users.get(2)?.uppercase()}")

//    println("Name: $name, Age: $age, PI: $pi, Grade: $grade, Is Active: $isActive")

    // ==
    // !=
    // > >=
    // < <=
    // +, - , *, /, %
    // ++, --

//    if (name == "Sara") {
//
//    } else {
//
//    }

//    var i = 1
//
//    while(i <= 10) {
//        println(i)
//        i++
//    }

//    var j = 11
//
//    do {
//        println(j)
//        j++
//    } while(j <= 10)

    for (num in 1 until 20 step 3) {
        println(num)
    }

    val colors: Array<String> = arrayOf("Gray", "Purple", "Green", "Black", "Red")

    for (color in colors) {
        println("The color is: $color")
    }

}