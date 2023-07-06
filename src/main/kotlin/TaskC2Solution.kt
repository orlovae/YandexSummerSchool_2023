import java.lang.StringBuilder

/**
С целью экономии чернил в картридже принтера было принято решение укоротить некоторые слова в тексте. Для этого
был составлен словарь слов, до которых можно сокращать более длинные слова. Слово из текста можно сократить, если
в словаре найдется слово, являющееся началом слова из текста. Например, если в словаре есть слово "лом", то слова
из текста "ломбард", "ломоносов" и другие слова, начинающиеся на "лом", можно сократить до "лом".

Если слово из текста можно сократить до нескольких слов из словаря, то следует сокращать его до самого короткого
слова.

Формат ввода
В первой строке через пробел вводятся слова из словаря, слова состоят из маленьких латинских букв. Гарантируется,
что словарь не пуст и количество слов в словаре не превышет 1000, а длина слов — 100 символов.

Во второй строке через пробел вводятся слова текста (они также состоят только из маленьких латинских букв).
Количество слов в тексте не превосходит 10e5, а суммарное количество букв в них — 10e6.

Формат вывода
Выведите текст, в котором осуществлены замены.
//наверное выведите изменённый текст

Пример 1
Ввод
a b
abdafb basrt casds dsasa a
Вывод
a b casds dsasa a

Пример 2
Ввод
aa bc aaa
a aa aaa bcd abcd
Вывод
a aa aa bc abcd
 */
class TaskC2Solution {
    private val scan = java.util.Scanner(System.`in`)
    private val dictionary = scan.nextLine().split(" ").toSet()
    private val text = scan.nextLine().split(" ")

    init {
        print(
            getModifiedText(dictionary, text)
        )
    }

    private fun getModifiedText(dictionary: Set<String>, text: List<String>): String {
        val modifiedText = StringBuilder()

        text.forEach { wordText ->
            var isModified = false
            var index = 0
            while (index <= wordText.lastIndex) {
                val tmp = wordText.substring(0, index)
                if (dictionary.contains(tmp)) {
                    modifiedText.append("$tmp ")
                    isModified = true
                    break
                }
                index++
            }

            if (!isModified) {
                modifiedText.append("$wordText ")
            }
        }
        return modifiedText.dropLast(1).toString()
    }
}