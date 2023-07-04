import kotlin.math.min

/**
 * Каждые сутки на вокзал прибывает n электричек. По заданному расписанию прибытия электричек определите
 * минимальное время между прибытием двух разных электричек.
 *
 * Формат ввода
 * В первой строке задано число n (1 ≤ n ≤ 2 × 10e4) — количество электричек.
 *
 * Во второй строке задано n моментов времени в формате HH:MM (0 ≤ HH ≤ 23, 0 ≤ MM ≤ 59) через пробел.
 *
 * Формат вывода
 * Выведите одно число — минимальное время в минутах между прибытием двух электричек.
 *
 * Пример 1
 * 2
 * 23:59 00:00
 * Вывод
 * 1
 * Пример 2
 * 3
 * 00:00 23:59 00:00
 * Вывод
 * 0
 */

class TaskD1 {
    private val scan = java.util.Scanner(System.`in`)
    private val countTrain = scan
        .nextLine()
        .toInt()
    private val diffTimeString = scan
        .nextLine()
        .split(" ")
    private val diffTimeInt = diffTimeString
        .map { timeToInt(it) }
        .sorted()

    init {
        var answer = 24 * 60 + diffTimeInt.first() - diffTimeInt.last()

        for (i in 1..diffTimeInt.lastIndex) {
            answer = min(answer, diffTimeInt[i] - diffTimeInt[i - 1])
        }

        print(answer)
    }
}

private fun timeToInt(time: String): Int {
    val hour = time
        .split(":")[0]
        .toInt()
    val minute = time
        .split(":")[1]
        .toInt()
    return hour * 60 + minute
}