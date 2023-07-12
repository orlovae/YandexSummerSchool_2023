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
class TaskB4 {
    private val countFriends = readln().toInt()
    private val dayList = readList(countFriends)

    init {
        var arrival = 0

        for (i in 0..dayList.lastIndex) {
            var departure = dayList[i].departure
            if (departure == 1) {
                arrival = -1
                departure = -1
                println("$arrival $departure")
            } else {
                arrival = when (arrival) {
                    -1 -> {
                        1
                    }

                    0 -> {
                        1
                    }

                    else -> {
                        if (i != 0) {
                            dayList[i - 1].departure
                        } else {
                            departure
                        }
                    }
                }
            }
            println("$arrival $departure")
        }

    }
}

private fun readList(countFriends: Int): MutableList<Days> {
    val daysList = mutableListOf<Days>()
    for (i in 0 until countFriends) {
        val inputLine = readln().split(" ").map { it.toInt() }
        daysList.add(
            Days(
                arrival = inputLine[0],
                departure = inputLine[1]
            )
        )
    }
    return daysList
}

private data class Days(
    val arrival: Int,
    val departure: Int
)