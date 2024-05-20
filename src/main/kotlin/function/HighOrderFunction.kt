package function

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p>高阶函数</p>
 *
 * @author hubinchang
 * @date 2024-05-16 09:56
 **/

// 定义了一个高阶函数，接受2个int的参数x,y，和一个方法参数operation。并返回int类型
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int) = x + y

// 定一个高阶函数，返回一个方法
fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x

fun main() {
    // 调用高阶函数，::sum在kotlin中是指按名称引用一个方法（sum并没有传两个int参数
    val sumResult = calculate(4, 5, ::sum)
    // 调用高阶函数，传递一个lambda表达式
    val mulResult = calculate(4, 5) { a, b -> a * b }
    println("sumResult $sumResult, mulResult $mulResult")
    println(" ")

    val func = operation()
    println(func(3))
}