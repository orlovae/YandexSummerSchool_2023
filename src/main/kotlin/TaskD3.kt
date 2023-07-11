/**
На прямой расположены стойла, в которые необходимо расставить коров так, чтобы минимальное расстояние между
коровами было как можно больше.

Формат ввода
В первой строке вводятся числа N (2 < N < 10001) – количество стойл и K (1 < K < N) – количество коров.
Во второй строке задаются N натуральных чисел в порядке возрастания – координаты стойл (координаты не превосходят
10e9)

Формат вывода
Выведите одно число – наибольшее возможное допустимое расстояние.

Пример
Ввод
6 3
2 5 7 11 15 20
Вывод
9
 */
class TaskD3 {
    private val lineFirst = readln().split(" ").map { it.toInt() }
    private val numberCows = lineFirst[1]
    private val stallList = readln().split(" ").map { it.toInt() }

    init {
        var left = 0
        var right = stallList.last()
        while (right > left) {
            val median = (left + right + 1) / 2
            if (check(median, numberCows, stallList)) {
                left = median
            } else {
                right = median - 1
            }
        }
        print(left)
    }
}

private fun check(median: Int, numberCows: Int, stallList: List<Int>) : Boolean {
    var countCow = 1
    var previousStall = stallList.first()

    for (i in 1..stallList.lastIndex) {
        if (stallList[i] - previousStall >= median) {
            countCow++
            previousStall = stallList[i]
        }
    }
    return countCow >= numberCows
}