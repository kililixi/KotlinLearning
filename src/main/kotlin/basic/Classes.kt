/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 09:54
 **/

// 可以什么都不写，包括大括号，会有默认的无参构造函数
class Customer

// 定义一个有两个属性的类，常量id，和变量email，会有默认的两个参数的构造函数
class Contact(val id: Int, var email: String)

fun main() {

    // 不用new
    val customer = Customer()

    val contact = Contact(1, "mary@gmail.com")

    println(contact.id)
    contact.email = "jane@gmail.com"

    // id改不了
//    contact.id = 1
}