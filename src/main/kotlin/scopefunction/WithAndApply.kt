package scopefunction

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-20 14:35
 **/

/*
在Kotlin中，apply 和 with 都是作用域函数，它们都可以用来执行一个对象的多个操作。但是，它们之间有两个主要的区别：
返回值:
apply 函数执行完代码块后，会返回接收者对象本身。
with 函数执行完代码块后，会返回代码块的最后一个表达式的结果。
调用方式:
apply 是一个扩展函数，它是直接调用在接收者对象上的。
with 是一个顶层函数，需要将接收者对象作为参数传递进去。
*/
class Configuration(var host: String, var port: Int)

fun main() {
    val configuration = Configuration(host = "127.0.0.1", port = 9000)

    // 可以使用这个with来打印,
    // 返回最后一行表达式
    with(configuration) {
        // 已经执行了
        println("$host:$port")
    }

    // 代替
    println("${configuration.host}:${configuration.port}")

    // with 与 apply的区别
    val withResult = with(configuration) {
        port = 8080
        // 返回最后一行表达式
        port
    }
    println("WithResult: $withResult")

    // 返回对象本身
    val applyResult = configuration.apply {
        port = 8081
    }.port
    println("ApplyResult: $applyResult")
}