package scopefunction

import kotlin.reflect.KProperty

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-20 16:10
 **/

/*
在 Kotlin 中，代理（Delegation）是一种设计模式，它允许将一个类的某些功能委托给另一个辅助类。
这种模式在 Kotlin 中得到了语言级别的支持，使得实现代理变得非常简洁和强大。

Kotlin 中的代理主要有两种形式：

1。类代理：通过使用 by 关键字，可以将接口的实现委托给另一个对象。例如：
2。属性代理：属性代理允许你将属性的 getter 和 setter 方法委托给一个代理对象。这可以通过 by 关键字实现，例如：
*/

interface SoundBehavior {                                                          // 1
    fun makeSound()
}

class ScreamBehavior(val n:String): SoundBehavior {                                // 2
    @OptIn(ExperimentalStdlibApi::class)
    override fun makeSound() = println("${n.uppercase()} !!!")
}

class RockAndRollBehavior(val n:String): SoundBehavior {                           // 2
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}

// TomAraya实现了 SoundBehavior 接口，by 关键字将 SoundBehavior 接口的所有方法委托给了 ScreamBehavior 对象。
class TomAraya(n:String): SoundBehavior by ScreamBehavior(n)
class ElvisPresley(n:String): SoundBehavior by RockAndRollBehavior(n)



// 属性代理
class Example {
    var p: String by Delegate()                                               // 1
    override fun toString() = "Example Class"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

fun main() {

    // 类代理
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()                                                           // 4
    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()

    //
}