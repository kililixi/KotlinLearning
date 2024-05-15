package basic

/**
 * <h3>HelloWorld</h3>
 * @description
 *
 * <p></p>
 *
 * @author hubinchang
 * @date 2024-05-15 16:25
 **/

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int) {                      // 1
    RED(1),                                    // 2
    GREEN(2),
    BLUE(3),
    YELLOW(4);
    fun containsRed() = (this.rgb and 0xFF0000 != 0)  // 3
}

fun main() {
    val state = State.RUNNING
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)
    print(State.RUNNING)
    println(" ")
    val red = Color.RED
    println(red)
    // 获取值
    println(red.rgb)                                      // 4
    println(red.containsRed())                        // 5
    println(Color.BLUE.containsRed())                 // 6
    println(Color.YELLOW.containsRed())               // 7
}