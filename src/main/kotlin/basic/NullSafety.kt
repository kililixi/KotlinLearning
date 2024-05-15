/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-14 17:04
 **/

//  Kotlin 在设计上就致力于消除空指针异常（NPE），这是许多编程语言中常见的问题。为了实现这一点，Kotlin 引入了几个核心概念：
//  1. 可空类型和非空类型：Kotlin 的类型系统区分可以持有 null 值的引用（可空引用）和不可以的引用（非空引用）。
//  例如，String? 表示一个变量可以持有字符串或者 null，而 String 表示变量不可以持有 null。

//  2. 安全调用操作符（?.）：这允许你安全地调用可能为 null 的对象的方法或属性。如果对象为 null，则不会调用方法或属性，也不会抛出 NPE。例如：

//  3. Elvis 操作符（?:）：这允许你提供一个当左侧表达式为 null 时使用的默认值

//  4. 非空断言操作符（!!）：这个操作符可以将任何值转换为非空类型，如果值为 null，则会抛出 NPE。这是一种明确告知编译器你确定这个值不会是 null 的方式。

//  5. 智能类型推断：Kotlin 编译器能够跟踪 null 检查，并允许在检查后安全地访问变量。
fun main() {

    // 不可为null
    var neverNull: String = "This can't be null"
//    neverNull = null

    // 可为null
    var nullable: String? = "You can keep a null here"
    nullable = null

    // 对于推断类型
    // 编译器假设有初始值的变量为非空类型，此时再设置null会报错
    var inferredNonNull = "The compiler assumes non-null"
//    inferredNonNull = null

    // 定义一个方法只接受非空类型的变量
    fun strLength(notNull: String): Int {
        return notNull.length
    }

    strLength(neverNull)
    // 报错，因为是可为空的变量
//    strLength(nullable)

    // 定义一个方法接受非空类型的变量
    fun strLength(notNull: String?): Int? {
        return notNull?.length
    }

    strLength(neverNull)
    // 正常，因为接受了可为空的参数
    strLength(nullable)

    nullable = "abc";
    // 如果 nullable 是 null，length 将会是 0。
    // 在非空变量上 使用的安全调用操作符 目前会返回Int
    // 不过在未来的kotlin版本上，返回的会是Int?,即使你是在not-null上调用
    val length = neverNull?.length ?: 0

    fun setValue(int: Int):String? {
        return if (int > 1) "True" else null
    }
    // 这里可能是 nullable
    nullable = setValue(1)
    // 直接调用length会提示，如果使用断言操作符 !!
//    println(nullable.length)

    // 断言不会为空就不会提示
    println(nullable!!.length)
}