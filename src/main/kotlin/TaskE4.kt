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
    private val path = readPath(sizePath)

    init {
        val tree = createTree(path)
        val count = 2
    }
}

private fun readPath(sizeList: Int): List<String> {
    val list = mutableListOf<String>()
    for (i in 0 until sizeList) {
        list.add(
            readln()
        )
    }
    return list
}

private class Node(
    var name: String,
    var level: Int,
    val list: MutableList<Node>? = null
) {
    fun insert(nodeString: String) {
        val tmp = nodeString.split(" ")
        val level = tmp.size - 1
        val name = tmp.last()
        val parentNode = getParentNode(this, level)
        parentNode?.list?.add(
            Node(
                name = name,
                level = level
            )
        )
    }

    private fun getParentNode(node: Node, level: Int): Node? {
        node.list?.forEach {
            if (it.level == level) {
                return it
            } else {
                getParentNode(it, level)
            }
        }
        return null
    }
}

private fun createTree(path: List<String>): Node {
    val node = Node(
        name = path.first(),
        level = 0
    )
    for (i in 1..path.lastIndex) {
        node.insert(path[i])
    }
    return node
}