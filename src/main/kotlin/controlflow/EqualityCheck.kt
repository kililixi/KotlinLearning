package controlflow

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 15:41
 **/
/*
在Kotlin中，== 和 === 两个操作符用于比较，但它们的比较方式有所不同：

== 是结构相等性（Structural Equality）的比较操作符，它用于比较两个对象的内容是否相等。在底层，它实际上会调用对象的 equals() 方法来判断两个对象的内容是否一致1。
=== 是引用相等性（Referential Equality）的比较操作符，它用于检查两个引用是否指向同一个对象的内存地址。也就是说，它会直接比较两个对象的引用地址是否相同1。
举个例子来说明这两者的区别：
*/

fun main() {
    val a: String = "Kotlin"
    val b: String = "Kotlin"
    val c: String = a

    println(a == b)  // 输出 true，因为a和b的内容相同
    println(a === b) // 输出 false，因为a和b不是同一个对象的引用
    println(a === c) // 输出 true，因为c是a的引用，指向同一个对象
}
