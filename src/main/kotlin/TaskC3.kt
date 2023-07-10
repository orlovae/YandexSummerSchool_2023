/**
На завод по изготовлению гирлянд пришел срочный заказ: изготовить как можно больше одинаковых гирлянд, состоящих
из n лампочек. На складе завода есть лампочки k различных цветов, цвета занумерованы от 1 до k. Определите,
сколько гирлянд сможет изготовить завод и из каких лампочек должна состоять каждая гирлянда.

Формат ввода
В первой строке задаются два числа n (1 ≤ n ≤ 40_000) и k (1 ≤ k ≤ 50_000).

В следующих k строках задается количество лампочек каждого из k цветов. Суммарное количество лампочек на складе не
превосходит 2 × 10e9.

Формат вывода
В первой строке выведите максимальное количество гирлянд. В следующих n строках выведите описание гирлянды: в
каждой строке выведите номер цвета лампочки, находящейся в гирлянде на очередном месте. Если возможных ответов
несколько — выведите любой из них.

Пример
Ввод
3 4
3
3
2
1
Вывод
2
1
2
3
 */
class TaskC3 {
    private val lineFirst = readln().split(" ").map { it.toInt() }
    private val lengthLights = lineFirst[0]
    private val countColorLight = lineFirst[1]
    private val colorLightList = readList(countColorLight)

    init {
        var answer = 0
        colorLightList.forEach {
            answer += it / lengthLights
        }
        println(answer)
        colorLightList.forEachIndexed { index, it ->
            if (it / answer >= 1) {
                println(index + 1)
            }
        }
    }
}

private fun readList(countColorLight: Int): MutableList<Int> {
    val colorLightList = mutableListOf<Int>()
    for (i in 0 until countColorLight) {
        colorLightList.add(readln().toInt())
    }
    return colorLightList
}