import java.io.BufferedReader
import java.io.File

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
    private val bufferedReader: BufferedReader = File("input.txt").bufferedReader()
    private val inputData = bufferedReader
        .use {
            it.readText()
        }
        .run {
            split("\n").filter { it.isNotEmpty() }
        }
    private val sizeMountainList = inputData[0].toInt()
    private val mountainList = inputData[1].trim().split(" ").map { it.toLong() }
    private val file = File("output.txt")

    init {
        for (i in 1 until sizeMountainList) {
            if (mountainList[i - 1] < mountainList[i] && mountainList[i] > mountainList[i + 1]) {
                file.bufferedWriter().use { bw -> bw.write((i + 1).toString()) }
                break
            }
        }
    }
}