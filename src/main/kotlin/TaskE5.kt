import kotlin.math.min

/**
Игра PitCraft происходит в двумерном мире, который состоит из блоков размером 1 на 1 метр. Остров игрока
представляет собой набор столбцов различной высоты, состоящих из блоков камня и окруженный морем. Над островом
прошёл сильный дождь, который заполнил водой все низины, а не поместившаяся в них вода стекла в море, не увеличив
его уровень. По ландшафту острова определите, сколько блоков воды осталось после дождя в низинах на острове.

Формат ввода
В первой строке записано натуральное число N (1≤N≤100_000) — количество столбцов, задающих ландшафт острова.
Во второй строке записано N натуральных чисел Hi (1≤Hi≤10e9) — высоты столбцов.

Формат вывода
Выведите одно число — количество блоков занятых водой.
Пример
Ввод
11
2 5 2 3 6 9 3 1 3 4 6
Вывод
18
 */
class TaskE5 {
    private val lastIndex = readln().trim().toInt() - 1
    private val columnList = readln().trim().split(" ").map { it.toInt() }
    private val stack = ArrayDeque<Column>()

    init {
        var answer = 0

        if (columnList[0] > columnList[1]) {
            stack.add(
                Column(
                    index = 0,
                    length = columnList[0]
                )
            )
        } else {
            stack.add(
                Column(
                    index = 1,
                    length = columnList[1]
                )
            )
        }
        var index = stack.last().index + 1
        while (index < lastIndex) {
            if (stack.size % 2 != 0) {
                while (index < lastIndex) {
                    val first = stack.last()
                    if (first.length == columnList[index] && index - first.index == 1) {
                        stack.removeLast()
                        val column = Column(
                            index = index,
                            length = columnList[index]
                        )
                        stack.add(column)
                        stack.add(column)
                        break
                    }
                    if (first.length < columnList[index]) {
                        val column = Column(
                            index = index,
                            length = columnList[index]
                        )
                        stack.add(column)
                        stack.add(column)
                        break
                    }
                    index++
                }
            }

        }
        println(stack)

        for (i in 1..stack.lastIndex step 2) {
            val first = stack[i - 1]
            val last = stack[i]
            val minColumn = min(first.length, last.length)
            for (j in first.index + 1 until last.index) {
                answer += minColumn - columnList[j]
            }
        }
        println(answer)
    }
}

private data class Column(
    val index: Int,
    val length: Int
)