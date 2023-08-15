import java.io.BufferedReader
import java.io.File
import java.lang.StringBuilder

/**
Имеется стол длины L. На столе разложено N носков так, что никакой носок не вылезает за границы стола.
Далее имеется умный мальчик Васька, который хочет замерить толщину покрытия стола носками в M точках.

Формат ввода
Во входном файле даны сначала L, N, M (1 ≤ L ≤ 10_000, 1 ≤ N ≤ 10_000, 1 ≤ M ≤ 100_000).

Далее идут N пар чисел l ≤ r от 1 до L – левые и правые концы носков.

Затем идут M чисел от 1 до L интересующие Васька точки.

Все числа целые.

Формат вывода
Выведите M чисел – толщину носкового покрытия в каждой точке.

Пример
Ввод
22 18 8
6 11
10 15
3 18
1 19
10 17
1 10
6 16
20 21
1 1
12 21
5 9
1 10
5 10
6 11
5 6
7 11
1 19
13 15
5
22
19
3
8
16
16
21
Вывод
8
0
3
5
11
6
6
2
 */
class TaskC4Solution {
    private val bufferedReader: BufferedReader = File("input.txt").bufferedReader()
    private val inputData = bufferedReader
        .use {
            it.readText()
        }
        .run {
            split("\n").filter { it.isNotEmpty() }
        }

    private val lineFirst = inputData[0].split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    private val tableLength = lineFirst[0]
    private val sizeSocksList = lineFirst[1]
    private val sockList = inputData.subList(1, sizeSocksList + 1)
    private val pointsList = inputData.subList(sizeSocksList + 1, inputData.size).map { it.trim().toInt() }
    private val file = File("output.txt")

    init {
        val eventList = getEventList(tableLength, sockList)
        val prefixList = mutableListOf<Int>()
        prefixList.add(eventList[0])
        for (i in 1..eventList.lastIndex) {
            prefixList.add(eventList[i] + prefixList[i - 1])
        }
        val output = StringBuilder()
        pointsList.forEach {
            output.append("${prefixList[it]} \n")
        }

        file.bufferedWriter().use { bw -> bw.write(output.toString()) }
    }

    private fun getEventList(tableLength: Int, sockList: List<String>): List<Int> {
        val list = MutableList(tableLength + 2) { 0 }
        for (i in 0..sockList.lastIndex) {
            val inputLine = sockList[i].split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
            val start = inputLine[0]
            val end = inputLine[1] + 1

            list[start] = list[start] + 1
            list[end] = list[end] - 1
        }
        return list
    }
}