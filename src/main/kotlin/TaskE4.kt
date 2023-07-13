/**
В операционной системе Xunil информация обо всех файлах и директориях хранится в специальном файле в следующем
формате:
1.avi
12
emoh
vonavi
a.doc
b.doc
vortep
.bashrc
vorodis
onrop
1.avi
2.avi
rav
bil
Имена файлов, и только они, содержат точку.
Требуется по данному имени файла найти путь к нему. Если таких файлов несколько, вывести путь к файлу, который
записан выше.

Формат ввода
В первой строке вводится имя искомого файла. Во второй строке вводится общее количество файлов и директорий. В
остальных строках вводится информация о файлах и директориях в указанном выше формате (директория или файл,
находящиеся внутри другой директории, отделяются одним дополнительным пробелом в начале строки). Количество строк
в файле и количество символов в каждой строке не превосходит 100.

Формат вывода
Выведите путь к файлу в формате /директория/директория/…/файл
Гарантируется, что такой файл есть.
Гарантируется, что длина строки ответа не превосходит 255.

Пример
1.avi
12
emoh
vonavi
a.doc
b.doc
vortep
.bashrc
vorodis
onrop
1.avi
2.avi
rav
bil
Вывод
/emoh/vorodis/onrop/1.avi
 */
class TaskE4 {
    private val fileName = readln()
    private val sizePath = readln().toInt()
    private val stack = getStack(sizePath, fileName)

    init {
        val answer = if (stack.toString().contains('/')) {
            stack.joinToString("/")
        } else {
            if (stack.size != 1) {
                "/${stack.toString()}"
            } else {
                "/${stack.last()}"
            }
        }
        println(answer)
    }
}

private fun getStack(sizeList: Int, fileName: String): ArrayDeque<String> {
    val stack = ArrayDeque<String>()
    val readLineRoot = readln().split(" ")
    var position = readLineRoot.lastIndex
    val root = deleteEmptyItemRight(readLineRoot).last()
    if (!root.contains('.')) {
        stack.add("/$root")
    }

    for (i in 1 until sizeList) {
        val readLine = readln().split(" ")
        val currentPosition = readLine.lastIndex
        val path = deleteEmptyItemRight(readLine).last()

        if (!path.contains('.')) {
            if (currentPosition < position) {
                stack.removeLast()
            }
            stack.add(path)
        } else {
            if (path == fileName) {
                stack.add(path)
                break
            }
        }

        position = currentPosition

    }
    return stack
}

private fun deleteEmptyItemRight(list: List<String>): List<String> {
    return if (list.size <= 1) {
        list
    } else {
        val mutableList = list.toMutableList()
        for (i in list.lastIndex downTo 0) {
            if (list[i].isEmpty()) {
                mutableList.removeAt(i)
            } else {
                break
            }
        }
        mutableList.toList()
    }
}