package scopefunction

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-20 09:48
 **/

/*
let 是一个高阶扩展函数，它可以用于对一个对象执行一个或多个操作，并返回结果。
具体来说，let 函数接受一个 lambda 表达式作为参数，并将调用它的对象作为参数传递给这个 lambda 表达式。
在 lambda 表达式中，这个对象可以通过 it 关键字来引用。

public inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

这里，T 表示对象的类型，R 表示 lambda 表达式返回的结果类型。block 是一个函数类型的参数，它接受一个 T 类型的参数并返回一个 R 类型的结果。

let 函数通常用于以下场景：

链式调用：可以在对象上进行一系列的操作，并返回最终的结果。
空安全调用：与 ?.（安全调用操作符）结合使用，只有在对象不为 null 时，才会执行 lambda 表达式。
局部变量的作用域限制：在 let 的 lambda 表达式中声明的变量，其作用域限制在表达式内部。

*/


@OptIn(ExperimentalStdlibApi::class)
fun customPrint(s: String) {
    print(s.uppercase())
}

fun printNonNull(str: String?) {
    println("Printing \"$str\":")

    // 使用安全调用?. ,这样let的代码只会在非null时调用
    str?.let {                         // 4
        print("\t")
        customPrint(it)
        println()
    }
}

fun printIfBothNonNull(strOne: String?, strTwo: String?) {
    // 嵌套，使用自定义的名称的话，内部的let代码块，就能调用外部let的对象，比如下面的 firstString
    strOne?.let { firstString ->
        strTwo?.let { secondString ->
            customPrint("$firstString : $secondString")
            println()
        }
    }
}

fun main() {
    // 执行打印，并返回最后一个表达式的结果，false
    val empty = "test".let {
        customPrint(it)
        it.isEmpty()
    }
    println(" is empty: $empty")

    printNonNull(null)
    printNonNull("my string")
    printIfBothNonNull("First","Second")
}