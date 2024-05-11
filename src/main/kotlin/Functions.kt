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

fun main() {
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(2, 4))
}