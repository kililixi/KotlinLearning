package collections

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * @author hubinchang
 * @date 2024-05-16 15:11
 **/
fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val first = numbers.first()
    val last = numbers.last()

    val firstEven = numbers.first { it % 2 == 0 }
    val lastOdd = numbers.last { it % 2 != 0 }

    println("Numbers: $numbers")
    println("First $first, last $last, first even $firstEven, last odd $lastOdd")

    // 如果没有匹配到，会抛出异常，此时可以用FirstOrNull
//    val firstEven2 = numbers.first { it % 2 == -2 }
    val firstEven2 = numbers.firstOrNull { it % 2 == -2 }
    val firstEven3 = numbers.find { it % 2 == -2 }
    println(firstEven2)
    println(firstEven3)
}