package basic

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 17:00
 **/

/*
在Kotlin中，object expression 是一种创建匿名对象的方式，这些对象没有一个具体的类声明。
这通常用于需要一次性使用的对象，或者当你需要创建一个类的轻微修改版但又不想显式声明一个新的子类时。
object expression 通过 object 关键字开始，并且可以从头开始定义，也可以继承现有的类或实现接口。
*/
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {

    // 创建一个匿名对象
    val dayRates = object {
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays

        override fun toString() = "hello world"
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special

    print("Total price: $$total")
    print(dayRates.toString())

}

open class Clickable {
    open fun click() {
        println("Clickable clicked")
    }
}

// object也可以用来声明一个类

class MyClickable : Clickable() {
    // override 重写方法
    override fun click() {
        println("My Clickable clicked")
    }
}

// 用object声明一个类，可以直接通过类名来调用
/*
Kotlin的 object 声明与Java中的静态类有几个关键区别：
1. 单例模式：Kotlin的 object 声明实际上是单例模式的一个实现。当你使用 object 关键字声明一个类时，Kotlin会自动为你创建一个单例对象。
这意味着 object 声明的类在整个应用程序中只有一个实例。
2. 初始化时机：Kotlin中的 object 在第一次被访问时初始化，而Java中的静态成员在类加载时初始化。这种差异可能会影响程序的行为，特别是在多线程环境中。
3. 继承：Kotlin的 object 可以继承其他类和实现接口，这与Java中的静态类不同。在Java中，静态内部类不能继承外部类的非静态成员。
4. 伴生对象：Kotlin没有静态方法或静态字段，但提供了 companion object。这是 object 的一个特殊用法，允许你在类内部定义一个对象，
其成员可以像Java中的静态成员一样被访问，但它们仍然允许接口实现和继承。
5. 可访问性：在Kotlin中，你可以直接通过 object 的名称访问其成员，而在Java中，你需要通过类名来访问静态成员。这使得Kotlin的 object 在语法上更加简洁。
*/
object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {        //2
        println("input Auth parameters = $username:$password")
    }
}

/*
companion object 被编译成 Java 的一个静态内部类。当你在 Kotlin 代码中使用 companion object 时，
它会在 Java 中生成一个名为 Companion 的静态内部类。这个类包含了所有原始 companion object 中的方法和属性。
如果在属性或方法上加上注解 @JvmStatic ，就会生成一个纯静态属性/方法，而不是静态内部类。
*/
class BigBen {                                  //1
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}

fun main() {
    rentPrice(10, 2, 1)
    println(" ")
    // object 也可以继承别的类
    // 如果是正常的继承，则还需要先定义一个类，再声明继承它
    val myClickable = object : Clickable() {
        override fun click() {
            println("Anonymous Clickable clicked")
        }
    }
    myClickable.click() // 输出: Anonymous Clickable clicked

    val myClickable2 = MyClickable()
    myClickable2.click()

    println(" ")
    // 与java的静态类不同，其实是kotlin生成了一个单例对象，是单例模式的一个实现。
    // 调用的时候，才生成对象。而static是加载时初始化
    DoAuth.takeParams("foo", "qwerty")
    println(" ")
    // 调用companion object，内部类的名字可以忽略
    BigBen.getBongs(12)
    println(" ")
    BigBen.Bonger.getBongs(12);
}