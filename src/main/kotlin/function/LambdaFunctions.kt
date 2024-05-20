package function

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-16 10:17
 **/

//@OptIn(ExperimentalStdlibApi::class)
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    // All examples create a function object that performs upper-casing.
    // 定义upperCase1函数， (String) -> String 表示接受一个string类型的参数，返回string类型的结果
    val upperCase1: (String) -> String = { str: String -> str.uppercase() } // 1

    // 忽略了lambda里的参数类型，
    val upperCase2: (String) -> String = { str -> str.uppercase() }         // 2

    // 编译器可以推断出该函数是一个接受 String 并返回 String 的函数类型 (String) -> String1。
    val upperCase3 = { str: String -> str.uppercase() }                     // 3

    // 不能两个都忽略
    // val upperCase4 = { str -> str.uppercase() }                          // 4

    val upperCase5: (String) -> String = { it.uppercase() }                 // 5

    val upperCase6: (String) -> String = String::uppercase                  // 6

    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}