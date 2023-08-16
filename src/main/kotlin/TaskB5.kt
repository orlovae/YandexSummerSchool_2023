import java.io.BufferedReader
import java.io.File

/**
Дана строка s и число k. В строке s требуется найти подстроку максимальной длины, в которой все различные символы
встречаются не менее k раз.

Формат ввода
Первая строка содержит через пробел два целых числа n и k (1≤n,k≤2x10e5) — длину строки s и минимальное количество
каждого из символов в искомой подстроке. Вторая строка содержит строку s (|s|= n), состоящую из строчных латинских
букв.

Формат вывода
Выведите одно число — максимальную длину подстроки, в которой все различные символы встречаются не менее k раз.
Пример 1
Ввод
5 3
aaabb
Вывод
3
Пример 2
Ввод
6 2
ababbc
Вывод
5
 */
class TaskB5 {
    private val bufferedReader: BufferedReader = File("input.txt").bufferedReader()
    private val inputData = bufferedReader
        .use {
            it.readText()
        }
        .run {
            split("\n").filter { it.isNotEmpty() }
        }
    private val firstString = inputData[0].trim().split(" ").map { it.toInt() }
    private val length = firstString[0]
    private val k = firstString[1]
    private val string = inputData[1].trim()
    private val map = mutableMapOf<Char, Int>()

    init {
        var answer = 0
        var previous = 0
        var current = 1
        var next = 2
        while (next <= string.lastIndex) {
            addMap(string[previous])

            if (string[current] == null && string[next] == null){

            }

        }

        println(answer)

    }

    private fun addMap(item: Char) {
        if (map[item] != null) {
            map[item] = map[item]!! + 1
        } else {
            map[item] = 1
        }

    }
}