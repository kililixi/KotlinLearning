/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 14:09
 **/

// kotlin的类默认是final，所以要允许别的类继承，就要加上open
open class Dog {
    // 方法默认也是final，要允许别的类重写，也需加上open
    open fun sayHello() {
        println("wow wow!")
    }
}
// Yorkshire 继承dog
class Yorkshire : Dog() {

    // override 重写方法
    override fun sayHello() {
        println("wif wif!")
    }
}

// 没加open就不能继承
//class YellowDog : Yorkshire() {}

// 有参构造函数
open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

// 继承时也需要参数
class SiberianTiger : Tiger("Siberia")
//class SiberianTiger2 : Tiger()

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}
// Asiatic的构造函数，接受一个名为name的参数，并且会传递给父类Lion
class Asiatic(name: String) : Lion(name = name, origin = "India")

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()

    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()

    val lion: Lion = Asiatic("Rufo")
    lion.sayHello()
}