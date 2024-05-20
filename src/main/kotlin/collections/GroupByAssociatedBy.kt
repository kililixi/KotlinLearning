package collections

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-16 15:29
 **/

/*
groupBy 函数是一个非常有用的集合操作函数，它可以根据指定的条件将集合中的元素分组。
groupBy 接受一个 lambda 表达式作为参数，这个 lambda 定义了分组的条件。它返回一个 Map，其中每个键是 lambda 表达式的结果，
而对应的值是一个列表，包含了所有产生这个结果的元素。

associateBy 功能类似，但是它对同一Key的不同元素，只取最后一个。
*/

@OptIn(ExperimentalStdlibApi::class)
fun main() {

    val words = listOf("apple", "apricot", "banana", "blueberry", "cherry")
    // 指定key的结果
    val groupedByFirstLetter = words.groupBy { it.first() }
    // 结果是 {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}
    println("groupedByFirstLetter: $groupedByFirstLetter")
    // 除了key，也指定 转换分组后的元素，将其作为大写
    val groupedByFirstLetterTransformed = words.groupBy(
        keySelector = { it.first() },
        valueTransform = { it.uppercase() }
    )
    println("groupedByFirstLetterTransformed: $groupedByFirstLetterTransformed")
    val map = words.associateBy { it.first() }
    // 结果是 {a=apricot, b=blueberry, c=cherry}
    println(map)
    println("")
    data class Person(val name: String, val city: String, val phone: String) // 1

    val people = listOf(                                                     // 2
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

    val phoneBook = people.associateBy { it.phone }                          // 3
    val cityBook = people.associateBy(Person::phone, Person::city)           // 4
    val peopleCities = people.groupBy(Person::city, Person::name)            // 5
    val lastPersonCity = people.associateBy(Person::city, Person::name)      // 6

    println("People: $people")
    println("Phone book: $phoneBook")
    println("City book: $cityBook")
    println("People living in each city: $peopleCities")
    println("Last person living in each city: $lastPersonCity")
}