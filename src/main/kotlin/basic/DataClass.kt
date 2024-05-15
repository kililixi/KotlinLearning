package basic

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 15:51
 **/

/*
在Kotlin中，data class 是一种特殊类型的类，主要用于存储数据。
Kotlin编译器为每个数据类自动生成了一些有用的成员函数，如 equals()、hashCode()、toString()、copy() 以及针对主构造函数中声明的属性的 componentN() 函数。
这些自动生成的函数使得数据类在处理数据时更加方便和高效。

要成为一个有效的数据类，它必须满足以下条件
主构造函数至少有一个参数。
所有主构造函数的参数必须标记为 val 或 var。
数据类不能是 abstract、open、sealed 或 inner。
数据类可以继承其他类，但是如果你需要在JVM上生成一个无参数的构造函数，你必须为属性指定默认值。
此外，只有在主构造函数中定义的属性才会被用于自动生成的函数。如果你想从自动生成的实现中排除一个属性，你可以在类体内声明它。
*/
data class User(val name: String, val id: Int) {           // 1
    override fun equals(other: Any?) =
        other is User && other.id == this.id               // 2
}

fun main() {
    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    //
    println(" ")
    // copy返回的是一个新对象，跟原本对象的指向不一样，所以不会相等
    println(user.copy())
    println(user === user.copy()) // false
    // copy 也可接受跟构造函数一样的参数，这时新的对象的值也会变
    println(user.copy("Max"))
    println(user.copy(id = 3))
    println(" ")
    println("name = ${user.component1()}")
    println("id = ${user.component2()}")
}