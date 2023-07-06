/**
Majority (в дословном переводе "большинство") — это значение элемента, который в массиве длиной n встречается
более чем n / 2 раз. Определите majority массива, если гарантируется, что такой элемент существует.

Формат ввода
В первой строке вводится число n (1 ≤ n ≤ 5 × 10e4).

Во второй строке вводится n чисел через пробел, числа не превосходят 109 по модулю.

Формат вывода
Выведите majority массива.

Пример 1
Ввод
3
1 2 1
Вывод
1

Пример 2
Ввод
7
7 5 5 5 5 4 5
Вывод
5
 */
class TaskD2Solution {
    private val scan = java.util.Scanner(System.`in`)
    private val sizeArray = scan.nextLine().toInt()
    private val array = scan.nextLine().split(" ").map { it.toInt() }

    init {
        val map = mutableMapOf<Int, Int>()

        run breaking@{
            array.forEach { key ->
                if (map[key] != null) {
                    map[key] = map[key]!! + 1
                    if (map[key]!! > array.size / 2) {
                        print(key)
                        return@breaking
                    }
                } else {
                    map[key] = 1
                }
            }
        }
    }
}