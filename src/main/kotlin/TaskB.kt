import java.lang.StringBuilder

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
class TaskBVer1 {
    private val scan = java.util.Scanner(System.`in`)
    private var inputString = scan.next()

    init {
        getCanonicalPath()
    }

    private fun getCanonicalPath() {
        val lexeme = '/'
        if (inputString[0] != lexeme) {
            inputString = "$lexeme$inputString"
        }
        inputString = inputString.replace("//", lexeme.toString())
            .replace("/\\./", lexeme.toString())
            .replace("/../", lexeme.toString())

        if (inputString[inputString.length - 1] == lexeme &&
            inputString != lexeme.toString()
        ) {
            inputString = inputString.dropLast(1)
        }

        println(inputString)
    }
}

class TaskBVer2 {
    val scan = java.util.Scanner(System.`in`)
    val inputString = scan.next()
    val canonPath: StringBuilder = java.lang.StringBuilder()
    val lexeme = '/'

    init {
        getCanonicalPath()
    }

    private fun getCanonicalPath() {
        inputString.split(lexeme).forEach {
            if (it != "." && it != ".." && it.isNotEmpty()) {
                canonPath
                    .append(lexeme)
                    .append(it)
            }
        }
        if (canonPath.isEmpty()) {
            println(lexeme)
        } else {
            println(canonPath.toString())
        }
    }
}