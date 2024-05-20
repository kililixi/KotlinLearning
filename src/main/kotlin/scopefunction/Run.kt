package scopefunction

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-20 14:19
 **/

//与let类似，但是run是在方法块内部是通过this来调用对象的

fun main() {
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {
            // 直接调用isEmpty()， 不用 it.isEmpty()
            println("\tis empty? " + isEmpty())                    // 2
            println("\tlength = $length")
            length                                                 // 3
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")
}