/**
Недавно Глеб катался в горах. Как известно, горный хребет - такой набор гор с высотами h1…hn, что в нем больше 3
гор и существует такая основная гора с индексом i, что 1<i<n и h1<h2<⋯<hi>hi+1>⋯>hn. Глеб помнит высоты всех гор,
более того он даже помнит, что это был горный хребет, вам требуется вывести индекс любой основной горы.

Формат ввода
В первой строчке дается одно число n - количество гор. Затем в следующей строчке дается n чисел : высоты гор hi.
3≤n≤10e4, 1≤hI≤10e9.

Формат вывода
Вам требуется вывести одно число - индекс любой основной горы.
Пример 1
Ввод
3
1 2 1
Вывод
2
Пример 2
Ввод
4
1 2 3 1
Вывод
3
 */
class TaskC5 {
    private val sizeMountainList = readln()
    private val mountainList = readln().trim().split(" ").map { it.toInt() }

    init {
        var firstIndex = 0
        var lastIndex = mountainList.lastIndex

        while (lastIndex > firstIndex) {
            val middleIndex = when {
                (firstIndex + lastIndex) / 2 == 0 -> {
                    1
                }
                (firstIndex + lastIndex) / 2 == lastIndex -> {
                    lastIndex - 1
                }
                else -> {
                    (firstIndex + lastIndex) / 2
                }
            }

            val previous = mountainList[middleIndex - 1]
            val current = mountainList[middleIndex]
            val next = mountainList[middleIndex + 1]
            when {
                previous < current && current > next -> {
                    println(middleIndex + 1)
                    println("value ${mountainList[middleIndex]}")
                    break
                }

                previous < current && current < next -> {
                    firstIndex = middleIndex + 1
                }

                previous > current && current > next -> {
                    lastIndex = middleIndex - 1
                }
            }
        }
    }
}