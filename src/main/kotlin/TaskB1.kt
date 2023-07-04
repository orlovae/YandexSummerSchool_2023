import kotlin.text.StringBuilder

/**
 * B. Канонический путь
 * По заданной строке, являющейся абсолютным адресом в Unix-системе, вам необходимо получить канонический адрес.
 * В Unix-системе "." соответсвутет текущей директории, ".." — родительской директории, при этом будем считать,
 * что любое количество точек подряд, большее двух, соответствует директории с таким названием (состоящем из
 * точек). "/" является разделителем вложенных директорий, причем несколько "/" подряд должны интерпретироваться
 * как один "/".
 * Канонический путь должен обладать следующими свойствами:
 * 1) всегда начинаться с одного "/"
 * 2) любые две вложенные директории разделяются ровно одним знаком "/"
 * 3) путь не заканчивается "/" (за исключением корневой директории, состоящего только из символа "/")
 * 4) в каноническом пути есть только директории, т.е. нет ни одного вхождения "." или ".." как соответствия текущей
 * или родительской директории
 *
 * Формат ввода
 * Вводится строка с абсолютным адресом, её длина не превосходит 100.
 *
 * Формат вывода
 * Выведите канонический путь.
 *
 * Пример 1
 * Ввод "/home/"
 * Вывод "/home"
 *
 * Пример 2
 * Ввод "/../"
 * Вывод "/"
 *
 * Пример 3
 * Ввод "/home//foo/"
 * Вывод "/home/foo"
 *
 * Примечания
 * В первом примере необходимо убрать "/" в конце строки
 * Во втором примере нельзя подняться выше корневой директории
 * В третьем примере несколко подряд идущих "/" должны замениться на один, а также необходимо убрать "/"
 * в конце строки
 */
class TaskB1 {
    private val scan = java.util.Scanner(System.`in`)
    private val inputString = scan.next()
    private val lexemeSlash = '/'
    private val lexemeOnePointer = "."
    private val lexemeTwoPointer = ".."

    init {
        getCanonicalPath()
    }

    private fun getCanonicalPath() {
        val list = getListStringSplitLexeme(inputString)
        val stack = getStackAnswer(list)

        printAnswer(stack)
    }

    private fun getListStringSplitLexeme(inputString: String): List<String> {
        val list = mutableListOf<String>()
        val arrayChar = inputString.toCharArray()
        var index = 0

        while (index <= arrayChar.lastIndex) {
            when (arrayChar[index]) {
                lexemeSlash -> index++
                else -> {
                    val item = StringBuilder()
                    while (index <= arrayChar.lastIndex && arrayChar[index] != lexemeSlash){
                        item.append(arrayChar[index])
                        index++
                    }
                    list.add(item.toString())
                }
            }
        }
        return list
    }

    private fun getStackAnswer(list: List<String>): ArrayDeque<String> {
        val stack = ArrayDeque<String>()
        list.forEach {
            if (it != lexemeOnePointer && it.isNotEmpty()) {
                stack.add(lexemeSlash + it)
            }

            if (it == lexemeTwoPointer) {
                stack.removeLast()
                if (stack.lastIndex > 0) {
                    stack.removeLast()
                }
            }
        }
        return stack
    }

    private fun printAnswer(stack: ArrayDeque<String>) {
        if (stack.isEmpty()) {
            print(lexemeSlash)
        } else {
            stack.forEach { print(it) }
        }
    }
}