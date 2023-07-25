import kotlin.math.min

/**
Вася переехал из своего родного города и очень скучает по старым друзьям. К сожалению, Вася снимает маленькую
квартиру и одновременно в гости к нему может приехать только один друг.
Каждый друг сказал Васе два числа A и B — с какого по какой день он может приехать в гости. Каждый друг приезжает
и уезжает в полдень. Каждый друг может приехать к Васе только один раз и остаться у него на несколько дней. Вася
хотел бы, чтобы суммарное количество дней, когда у него в гостях есть кто-нибудь из друзей, было максимальным.
Помогите ему определить даты приезда для каждого из друзей так, чтобы они не пересекались (допустима ситуация,
что в один день один из друзей приезжает, а другой — уезжает) и суммарное время, когда у Васи в гостях есть кто-то
из друзей, было максимальным.

Формат ввода
В первой строке записаны целое число N (1 ≤ N ≤ 100000) - количество друзей Васи.
В следующих N строках записано по два целых числа Ai и Bi (оба числа от 1 до 109) — возможное время приезда i-го
друга.

Формат вывода
Выведите N пар чисел Li и Ri - номера дней, в которые приедет и уедет i-й друг соответственно (Ai ≤ Li ≤ Ri ≤ Bi).
Если i-го друга приглашать не нужно, выведите пару чисел -1 -1. Если правильных ответов несколько - выведите любой
из них.

Пример 1
Ввод
3
1 2
2 4
3 5
Вывод
1 2
3 4
5 5
Пример 2
Ввод
3
2 3
1 4
3 5
Вывод
-1 -1
1 4
5 5
 */
class TaskB4Solution {
    private val countFriends = readln().trim().toInt()
    private val friendList = readList(countFriends)

    init {
        val answer = MutableList(countFriends) { Friend(index = it) }
        var currentArrival = 0
        var currentDeparture = 0
        var currentIndex = -1

        friendList.forEach {
            if (it.departureDay > currentDeparture) {
                if (currentIndex != -1) {
                    answer[currentIndex] = Friend(
                        arrivalDay = currentArrival,
                        departureDay = min(it.arrivalDay, currentDeparture),
                        index = currentIndex
                    )
                }
                currentArrival = it.arrivalDay
                currentDeparture = it.departureDay
                currentIndex = it.index
            }
            if (currentIndex != -1) {
                answer[currentIndex] = Friend(
                    arrivalDay = currentArrival,
                    departureDay = currentDeparture,
                    index = currentIndex
                )
            }

        }

        answer.forEach {
            println("${it.arrivalDay} ${it.departureDay}")
        }
    }

}

private fun readList(countFriends: Int): MutableList<Friend> {
    val friendList = mutableListOf<Friend>()
    for (i in 0 until countFriends) {
        val inputLine = readln().trim().split(" ").map { it.toInt() }
        friendList.add(
            Friend(
                arrivalDay = inputLine[0],
                departureDay = inputLine[1],
                index = i
            )
        )
    }
    friendList.sortBy { it.arrivalDay }
    return friendList
}

private data class Friend(
    val arrivalDay: Int = -1,
    val departureDay: Int = -1,
    val index: Int,
)