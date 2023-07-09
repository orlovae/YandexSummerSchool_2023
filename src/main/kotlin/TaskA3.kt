/**
Дана последовательность чисел и запросы вида "определите сколько положительных чисел на отрезке с индексами от L
до R".

Формат ввода
В первой строке вводится число n (1 ≤ n ≤ 100_000) — длина последовательности.
Во второй строке вводится последовательность из n целых чисел, все числа по модулю не превосходят 100_000.
Нумерация в последовательности начинается с единицы.
В первой строке вводится число q (1 ≤ q ≤ 100_000) — количество запросов.
В каждой из следующих q строк вводятся запросы — два индекса l и r (1 ≤ l ≤ r ≤ n)

Формат вывода
Для каждого запроса выведите количество положительных на отрезке.

Пример
Ввод
5
2 -1 2 -2 3
4
1 1
1 3
2 4
1 5
Вывод
1
2
1
3
 */
class TaskA3 {
    private val sizeList = readln().toInt()
    private val list = readln().split(" ").map { it.toInt() }
    private val countRequest = readln().toInt()
    private val listRequest = readList(countRequest)

    init {
        val listPrefixPositive = getListPrefixPositive(list)

        listRequest.forEach {
            val request = it
            val end = request.end
            val start = request.start
            val answer = if (end == start || start == 0) {
                listPrefixPositive[end]
            } else {
                listPrefixPositive[end] - listPrefixPositive[start]
            }
            if (it != listRequest.last()) {
                println(answer)
            } else {
                print(answer)
            }
        }
    }
}

private fun getListPrefixPositive(list: List<Int>): List<Int> {
    val listPrefixPositive = mutableListOf<Int>()
    var count = 0

    list.forEach {
        if (it > 0) {
            count += 1
        }
        listPrefixPositive.add(count)
    }
    return listPrefixPositive
}

private fun readList(countRequest: Int): MutableList<Request> {
    val arrayRequest = mutableListOf<Request>()
    for (i in 0 until countRequest) {
        val inputRequest = readln().split(" ").map { it.toInt() }
        arrayRequest.add(
            Request(
                start = inputRequest[0] - 1,
                end = inputRequest[1] - 1
            )
        )
    }
    return arrayRequest
}

private data class Request(
    val start: Int,
    val end: Int
)