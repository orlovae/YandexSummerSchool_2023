/**
Вася и Петя играют в игру «Быки и коровы». Вася загадал число состоящее из N цифр, а Петя пытается его отгадать.
Петя называет число из N цифр, а Вася отвечает, сколько в нем «быков» и «коров». Количество «быков» вычисляется
как количество цифр, стоящих на своем месте. Количество «коров» вычисляется как количество цифр, которые есть и
загаданном Васей числе и в названном Петей, но стоят на разных местах. То есть эти цифры могут быть переставлены
таким образом, чтобы стать «Быками». По загаданному Васей и названному Петей числам определите количество «быков»
и «коров».

Формат ввода
Загаданное Васей и Петей числа положительные и вводятся по одному в строке. Количество цифр в числах не
превосходит 1_000. Числа не имеют ведущих нулей.
Формат вывода
В первой строке выведите количество «быков», а во второй — «коров».
Пример
Ввод
1370
7311
Вывод
1
2
Примечания
В числах 1370 и 7311 есть один «бык» (цифра 3), а также две «коровы» — одна из цифр 1 и цифра 7.
 */
class TaskA5Solution {
    private val numbersVasya = readln().trim()
    private val numbersPetya = readln().trim()
    private val mapNumberVasya = mutableMapOf<Int, Int>()
    private val mapNumberPetya = mutableMapOf<Int, Int>()

    init {
        var countBulls = 0
        var countCows = 0
        for (i in 0..numbersVasya.lastIndex) {
            val itemVasya = numbersVasya[i].digitToInt()
            val itemPetya = numbersPetya[i].digitToInt()
            if (itemVasya == itemPetya) {
                countBulls += 1
            } else {
                mapAddItem(itemVasya, mapNumberVasya)

                mapAddItem(itemPetya, mapNumberPetya)
            }
        }

        for (i in 0..9) {
            val countCharVasya = mapNumberVasya[i] ?: 0
            val countCharPetya = mapNumberPetya[i] ?: 0
            if (countCharVasya == countCharPetya) {
                countCows += countCharVasya
                continue
            }
            countCows += if (countCharVasya > countCharPetya) {
                countCharPetya
            } else {
                countCharVasya
            }
        }

        println(countBulls)
        println(countCows)
    }

    private fun mapAddItem(item: Int, map: MutableMap<Int, Int>) {
        if (map[item] != null) {
            map[item] = map[item]!! + 1
        } else {
            map[item] = 1
        }
    }
}