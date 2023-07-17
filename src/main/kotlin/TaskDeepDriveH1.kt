/**
У Васи есть n друзей. В преддверии праздников он решил подготовить для них подарки. Он знает, какой подарок и
насколько сильно обрадует каждого друга, а также стоимость этого подарка. Вася хочет сделать всех друзей как можно
счастливее, но при этом у него есть всего t рублей. Помогите Васе понять, какой будет минимальная радость среди
всех друзей, если Вася будет выбирать подарки оптимальным образом.
Формат ввода
В первой строке содержатся два числа n 1≤n≤10e5 – количество друзей Васи и t 1≤t≤10e18 – количество денег. Далее
идет n блоков, в первой строке каждого блока содержится одно число 0≤ki≤10e5, где k – количество подарков, у
которых Вася знает стоимость и ценность для i-го друга. В следующих k строках содержится два числа: p (1≤p≤10e12)
- стоимость подарка и h (1≤h≤10e5) радость друга от этого подарка.
Гарантируется, что сумма всех ki не превышает 10e5.

Формат вывода
По полученным данным выведите одно число – минимальную радость от подарка среди всех друзей, если Вася потратит на
подарки не более t рублей. В случае если кому-то подарка не достанется, его радость будет равна 0.
Пример
Ввод
3 6
2
2 10
1 10
1
3 5
3
1 15
2 2
4 25
Вывод
5
 */
class TaskDeepDriveH1 {
    private val firstLine = readln().split(" ").map { it.toInt() }
    private val countFriends = firstLine[0]
    private val list = readList(countFriends)

    init {
        println(list.min())
    }
}

private fun readList(size: Int): List<Int> {
    val answerList = mutableListOf<Int>()
    var sumHappiness = 0

    for (i in 0 until size) {
        val countGift = readln().toInt()

        for (j in 0 until countGift) {

            sumHappiness += readln().split(" ").map { it.toInt() }.last()

        }
        answerList.add(sumHappiness)
        sumHappiness = 0
    }
    return answerList.toList()
}