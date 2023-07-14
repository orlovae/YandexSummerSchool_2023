/**
Вася придумал игру для умного телевизора: можно выбрать две произвольные буквы латинского алфавита и заменить в
строке все вхождения первой буквы на вторую, а второй — на первую. Так при выборе буквы a и b строка abc
превратится в bac. Если выбрать буквы a и x, то строка abc превратится в строку xbc. Цель игры состоит в том,
чтобы получить из строки s1 строку s2.
К сожалению, Вася умеет только генерировать гениальные идеи, но не программировать. Он придумал много пар строк s1
и s2. Для каждой пары определите, возможно ли получить из строки s1 строку s2 по правилам игры.

Формат ввода
В первой строке задано число t (1 ≤ t ≤ 100) — количество пар строк, придуманных Васей. В следующих t строках
вводятся две слова равной длины, разделенных пробелом и состоящих из строчных латинских букв — s1 и s2
соответственно. Гарантируется, что суммарная длина всех слов не превосходит 10e5 символов.

Формат вывода
Для каждой пары слов выведите YES, если из s1 можно получить s2 по правилам игры и NO в противном случае.

Пример
Ввод
4
abcd
pqrs
abc
zyc
sssss
ppppp
xx
ab
Вывод
YES
YES
YES
NO

 */
class TaskB0 {
    private val sizeWordList = readln().toInt() * 2

    init {
        val list = readListWord()
        val wordNoRecurringCharList = mutableListOf<String>()
        list.forEach {
            wordNoRecurringCharList.add(
                deleteRecurringChar(it)
            )
        }

        for (i in 1..list.lastIndex step 2) {
            val pairLetterSet = getPairLetterSet(list[i - 1], list[i])
            println(
                getAnswer(
                    first = wordNoRecurringCharList[i - 1],
                    second = wordNoRecurringCharList[i],
                    set = pairLetterSet
                )
            )
        }
    }

    private fun readListWord(): List<String>{
        val list = mutableListOf<String>()
        for (i in 0 until sizeWordList) {
            list.add(
               readln()
            )
        }
        return list
    }

    private fun getAnswer(first: String, second: String, set: Set<PairLetter>): String {
        if (first.length != second.length) {
            return NO
        }

        return if (first.length != set.size) {
            NO
        } else {
            YES
        }
    }

    private fun getPairLetterSet(firstWord: String, secondWord: String): Set<PairLetter> {
        val set = mutableSetOf<PairLetter>()

        for (i in 0..firstWord.lastIndex) {
            set.add(
                PairLetter(
                    letterFromFirstWord = firstWord[i],
                    letterFromSecondWord = secondWord[i]
                )
            )
        }

        return set
    }

    private fun deleteRecurringChar(word: String): String {
        val set = mutableSetOf<Char>()
        val sb = StringBuilder()

        word.forEach { set.add(it) }

        set.forEach { sb.append(it) }

        return sb.toString()
    }

    companion object {
        const val YES = "YES"
        const val NO = "NO"
    }
}

private data class PairLetter(
    val letterFromFirstWord: Char,
    val letterFromSecondWord: Char,
)