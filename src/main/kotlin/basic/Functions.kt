package basic

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p>Functions</p>
 *
 * @author hubinchang
 * @date 2024-05-11 17:08
 **/

// Unit类型与Java中的void类型相似，用于表示一个函数不返回任何有意义的值,如果一个函数没有显式指定返回类型，那么它的默认返回类型就是Unit
fun printMessage(message: String): Unit {
    println(message)
}

// 接收第二个可选参数（默认值为 Info）的函数。省略了返回类型，这意味着它实际上是 Unit。
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

// 返回Int类型
fun sum(x: Int, y: Int): Int {                                          // 3
    return x + y
}

// 推断返回Int类型
fun multiply(x: Int, y: Int) = x * y                                    // 4

// 中缀函数
//Infix Functions（中缀函数）是一种特殊的函数，它允许你在调用函数时不使用点（.）和括号（()）。这种函数调用方式使得代码看起来更像自然语言。
//
//要创建一个中缀函数，需要满足以下条件：
//函数必须是成员函数或扩展函数。
//函数只能有一个参数。
//函数前必须加上 infix 关键字。
fun infixf() {
    // 这个函数定义了一个 Int 类型的扩展函数 times，它接受一个 String 类型的参数，并返回这个字符串重复 Int 次的结果。
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    // McLaren 加上 Lucas, 并返回一个list
    val myPair = "McLaren" onto "Lucas"
    println(myPair)
}

// 中缀函数在类的成员函数上也是可以用的
class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}

//Operator Functions（操作符函数）允许你为自定义类型重载预定义的操作符，比如加号（+）或者乘号（*）。这意味着你可以定义如何使用这些操作符来操作你的自定义类型的对象。
//
//要重载一个操作符，你需要提供一个具有特定名称的成员函数或扩展函数。这个函数必须使用 operator 关键字进行标记。例如，如果你想重载 + 操作符，你需要提供一个名为 plus 的函数。
//以下是一些常见的操作符函数和它们对应的 Kotlin 函数名：
//+ 对应 plus
//- 对应 minus
//* 对应 times
/// 对应 div
//% 对应 rem
//.. 对应 rangeTo
fun operatorFun() {
    // 定义了一个操作符函数 times，它是 Int 类型的扩展函数
    operator fun Int.times(str: String) = str.repeat(this)       // 1
    println(2 * "Bye ")                                          // 重复两次Bye

    // 操作符函数，它允许你使用方括号来获取字符串的子串。这个函数是 String 类型的扩展函数，它重载了 get 操作符。
    // get是操作符函数的名称，对应于索引访问操作符 []
    operator fun String.get(range: IntRange) = substring(range)  // 3
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
}

// vararg 可变数量的参数,可以传递任意数量的参数给函数，而不需要事先定义每个参数,这些参数在函数内部会被当作一个数组来处理
fun printAll(vararg messages: String) {                            // 1
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
    for (m in messages) println(prefix + m)
}

fun main() {
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(2, 4))

    infixf()
    operatorFun()

    printAll("Hello", "Hallo", "Salut", "Hola", "你好")
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "                                          // 4
    )
}