package collections

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-16 16:05
 **/
fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)                // 1
    // 分割数组
    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    val evenOdd2 = numbers.partition { it > 0 } // 3
    val (positivesaaa, negativesbbb) = numbers.partition { it > 0 } // 3
    println("Numbers: $numbers")
    println("evenOdd2: $evenOdd2")
    println("Even numbers: ${evenOdd.first}")
    println("Odd numbers: ${evenOdd.second}")
    println("Positive numbers: $positivesaaa")
    println("Negative numbers: $negativesbbb}")
}