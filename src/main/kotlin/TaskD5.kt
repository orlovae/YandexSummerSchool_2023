/**
Дана изначальная строка s. За одну операцию можно: Взять непустой префикс строки состоящий из одинаковых букв.
Взять непустой суффикс строки состоящий из одинаковых букв. И префикс, и суффикс должны состоять из одних и тех же
букв. Префикс и суффикс не должны пересекаться по символам. Префикс и суффикс не обязательно равной длины. Удалить
полученные префикс и суффикс из строки.
Посчитайте длину минимальной строки, которую можно получить из изначальной, после применения некоторого числа
данных операций (возможно нуля).

Формат ввода
В единственной строке вводится изначальная строка s(1≤∣s∣≤10e5). Строка состоит из строчных букв латинского
алфавита.
Формат вывода
В качестве ответа выведите единственное число — минимальную возможную длину строки после применения некоторого
числа операций.
Пример 1
Ввод
abba
Вывод
0
Пример 2
Ввод
aboba
Вывод
1
Пример 3
Ввод
zzzaabxxxcazz
Вывод
5
Примечания
В первом примере мы сначала выбираем префикс и суффикс "a" удаляем их, получив строку "bb". Затем выбираем префикс
и суффикс "b"и также удаляем их, удалив всю строку. Во втором примере мы выбираем такие же суффиксы и префиксы:
"aboba" → "bob" → "o". Можно показать, что единственный символ "o"никак нельзя удалить.
В третьем примере в качестве первой операции можно выбрать например префикс "zz"и суффикс "z".
zzzaabxxxcazz
aabxxxca
bxxxc
 */
class TaskD5 {
    private val string = readln().trim()

    init {
        val mutableString = StringBuilder(string)

        while (mutableString.first() == mutableString.last()) {
            if (mutableString.length == 1) {
                break
            }
            if (mutableString.length == 2 && mutableString.first() == mutableString.last()) {
                mutableString.clear()
                break
            }
            if (mutableString.length == 3 && mutableString.first() == mutableString.last()) {
                mutableString.deleteCharAt(0)
                mutableString.deleteCharAt(1)
                break
            }

            var startStart = 0
            var startEnd = mutableString.length
            while (startStart < startEnd) {
                val medium = (startStart + startEnd + 1) / 2
                if (mutableString[startStart] == mutableString[medium]) {
                    startStart = medium
                } else {
                    startEnd = medium - 1
                }

            }
            mutableString.delete(0, startStart + 1)

            if (mutableString.isEmpty()) {
                break
            }

            var endEnd = mutableString.lastIndex
            var endStart = endEnd / 2
            while (endStart < endEnd) {
                val medium = (endStart + endEnd) / 2
                if (mutableString[medium] == mutableString[endEnd]) {
                    endEnd = medium
                } else {
                    endStart = medium + 1
                }
            }
            mutableString.delete(endStart, mutableString.length)

        }
        println(mutableString.length)
    }
}