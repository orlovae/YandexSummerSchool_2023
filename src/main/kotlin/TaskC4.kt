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
class TaskC4 {
    private val lineFirst = readln().split(" ").map { it.toInt() }
    private val tableLength = lineFirst[0]
    private val sizeSocksList = lineFirst[1]
    private val sizePointsList = lineFirst[2]
    private val socksList = readSocksList(sizeSocksList)
    private val pointsList = readPointList(sizePointsList)

    init {

    }
}

private fun readSocksList(sizeList: Int): MutableList<Sock> {
    val list = mutableListOf<Sock>()
    for (i in 0 until sizeList) {
        val inputLine = readln().split(" ").map { it.toInt() }
        list.add(
            Sock(
                left = inputLine[0],
                right = inputLine[1]
            )
        )
    }
    return list
}

private data class Sock(
    val left: Int,
    val right: Int
)

private fun readPointList(sizeList: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    for (i in 0 until sizeList) {
        val point = readln().toInt()
        list.add(point)
    }
    return list
}