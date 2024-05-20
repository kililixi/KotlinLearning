package function

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-16 11:09
 **/

// 定义两个数据类
data class Item(val name: String, val price: Float)                                         // 1
data class Order(val items: Collection<Item>)

// 给Order类添加拓展方法 maxPricedItemValue 和 maxPricedItemName
// maxByOrNull 是根据某个属性来获取最大的值， { it.price } 其实是高阶函数的一个传参方式？
// this.items.maxByOrNull { it.price } 返回的一个item对象，但是要在为null的设置一个默认值，所以最后加上 ?; OF
fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F    // 2
// 同上
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"
// 获取collection里的所有item对象，并拼接其name
val Order.commaDelimitedItemNames: String                                                   // 3
    get() = items.map { it.name }.joinToString()

// 定义一个函数，如果不为空就转字符串，不然返回"NULL"
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"  // 1

fun main() {
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")                           // 4
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")
    println(" ")
    println(null.nullSafeToString())
    println("Kotlin".nullSafeToString())
}
