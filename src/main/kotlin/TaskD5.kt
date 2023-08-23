import java.io.BufferedReader
import java.io.File

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
    private val bufferedReader: BufferedReader = File("input.txt").bufferedReader()
    private val string = bufferedReader
        .use {
            it.readText().trim()
        }

    init {

        var start = 0
        var end = string.lastIndex

        while (start < end && string[start] == string[end]) {
            val tmp = string[start]
            while (start < end && string[start] == string[end]) {
                start += 1
            }

            while (end >= start && tmp == string[end]) {
                end -= 1
            }
        }
        println(end - start + 1)
    }
}