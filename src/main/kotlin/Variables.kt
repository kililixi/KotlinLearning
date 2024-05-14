/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-11 17:07
 **/

const val NAME = "Copilot"

fun setValue(int: Int):String {
    return if (int > 1) "True" else "False"
}
fun main() {

//    总结来说，var 是可变变量，val 是只读变量，而 const 是编译时常量。
//    val 和 const 都不能在初始化后被重新赋值，但 val 可以在运行时初始化，而 const 必须在编译时初始化。

    var a: String = "initial"  // 1
    println(a)
    a = "initial--2"
    println(a)
    val b: Int = 1             // 2
    val c = 3

    println(b)
    println(c)
    println(NAME)
//    NAME = "111"

    // val可以在运行时初始化是指，可以在程序运行时，根据程序的逻辑和条件来确定其值。
    // 这与 const 声明的编译时常量不同，后者的值必须在编译时就已经确定。
    val d = setValue(1)
    print(d)

    val e: Int  // 1

    if (1 > 2) {
        e = 1   // 2
    } else {
        e = 2   // 2
    }

    println(e) // 3
}