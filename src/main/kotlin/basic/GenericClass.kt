/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 11:00
 **/

// 泛型类
class MutableStack<E>(vararg items: E) {              // 泛型参数
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}


// 单独的泛型方法
// *elements 代表星号投影
/*
    星号投影（Star Projection）是一种使用泛型时的语法，它表示你不知道或者不关心具体的泛型参数类型
    当你想要使用一个泛型类型但是不关心具体的类型参数时。例如，如果你有一个 List<*>，这意味着你有一个列表，但是你不关心列表中元素的具体类型。
    当你想要安全地访问泛型类型的数据，但不会修改它时。使用星号投影的泛型类型，你可以读取数据（因为所有的类型都是 Any? 的子类型），
    但不能写入数据（因为你不知道什么类型是安全的）。
 */
/*
Kotlin的星号投影（Star Projection）和Java中的通配符类型（Wildcard Types）都是处理泛型时的语法结构，但它们在概念和使用上有一些区别：

1. 声明处协变与逆变：Kotlin通过声明处协变（declaration-site variance）和类型投影（type projections）来替代Java的通配符。
   这意味着在Kotlin中，你可以在类或接口声明时指定类型参数的协变（out）或逆变（in），而Java的通配符是在使用处指定的。
2. 类型系统的差异：在Java中，使用 List<?> 表示你有一个列表，但不关心列表中元素的具体类型。
   所有的Java引用类型默认都是可空的，所以你可以安全地将 null 作为未知类型的参数传递。而在Kotlin中，MutableList<*> 实际上结合了 out Any?
   和 in Nothing 投影，后者意味着你不能向方法传递任何未知类型的参数（Nothing 是没有任何值的类型
3. 空安全：Kotlin的类型系统设计为默认不可空，这与Java的可空性相反。因此，在Kotlin中使用星号投影时，你不能像在Java中那样传递 null，
   因为Kotlin要求明确的空安全检查
   总的来说，Kotlin的星号投影提供了一种更加严格的类型安全方式，而Java的通配符类型则更加灵活，允许类型参数为 null。Kotlin的这种设计旨在减少运行时错误，并提高代码的可读性和安全性.*/
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

//在Kotlin中，声明处协变（declaration-site variance）和逆变（contravariance）是泛型类型系统的两个重要概念，
//它们允许你在类或接口声明时指定类型参数的变异性，从而提高代码的灵活性和安全性。
//java中存在 https://blog.csdn.net/ShuSheng0007/article/details/108708218

/*
声明处协变（Covariance）:
    1. 使用关键字 out 来标记类型参数，表示这个类型参数只能被生产（produced）而不能被消费（consumed）。
    2. 协变类型参数可以安全地将子类型对象赋值给父类型引用。
    3. 例如，如果 Animal 是 Dog 的父类，那么 List<out Animal> 可以引用 List<Dog> 的实例。

声明处逆变（Contravariance）:
    1. 使用关键字 in 来标记类型参数，表示这个类型参数只能被消费而不能被生产。
    2. 逆变类型参数可以安全地将父类型对象赋值给子类型引用。
    3. 例如，如果 Animal 是 Dog 的父类，那么 List<in Dog> 可以引用 List<Animal> 的实例。

不变（Invariance）:
    1. 如果没有使用 out 或 in 关键字，类型参数就是不变的。
    2. 不变类型参数既不能安全地接受子类型也不能接受父类型。
    3. 例如，List<Animal> 不能引用 List<Dog> 或 List<Cat> 的实例。
*/

// Kotlin中使用out关键字声明协变
// 生产（Produced）：意味着类型参数 T 用于方法的返回类型。
interface Producer<out T> {
    fun produce(): T
}

// Kotlin中使用in关键字声明逆变
// 消费（Consumed）：意味着类型参数 T 用于方法的输入参数
interface Consumer<in T> {
    fun consume(item: T)
}

fun main() {

    // 泛型方法
    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)
}
