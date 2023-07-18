/**
 * Вам дана последовательность измерений некоторой величины. Требуется определить, повторялось ли какое-либо число,
 * причём расстояние между повторами не превосходило k.
 * Формат ввода
 * В первой строке задаются два числа n и k (1 ≤ n, k ≤ 10e5).
 * Во второй строке задаются n чисел, по модулю не превосходящих 10e9.
 * Формат вывода
 * Выведите YES, если найдется повторяющееся число и расстояние между повторами не превосходит k и NO в противном
 * случае.
 *
 * Пример 1
 * 4 2
 * 1 2 3 1
 * Вывод
 * NO
 * Пример 2
 * 4 1
 * 1 0 1 1
 * Вывод
 * YES
 * Пример 3
 * 6 2
 * 1 2 3 1 2 3
 * Вывод
 * NO
https://contest.yandex.ru/contest/50242/problems/
https://contest.yandex.ru/contest/28415/problems/
 */
class TaskA2 {
    private val inputFirst = readln()
        .trim()
        .split(" ")
        .map { it.toInt() }
    private val inputSecond = readln()
        .trim()
        .split(" ")
        .map { it.toInt() }
    private val requirement = inputFirst[1]

    init {
        print(
            getAnswer(inputSecond)
        )
    }

    private fun getAnswer(input: List<Int>): String {
        val map = mutableMapOf<Int, Int>()
        input.forEachIndexed { index, it ->
            val diff = map[it]?.let { value ->
                index - value
            }

            if (diff != null && diff == requirement) {
                return ("YES")
            }
            map[it] = index
        }
        return ("NO")
    }
}