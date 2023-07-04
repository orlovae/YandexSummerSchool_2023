/**
 * C. Купить и продать
 * У вас есть 1000$, которую вы планируете эффективно вложить. Вам даны цены за
 * 1000 кубометров газа за n дней. Можно один раз купить газ на все деньги в день
 * i и продать его в один из последующих дней j, i < j.
 * Определите номера дней для покупки и продажи газа для получения максимальной
 * прибыли.
 *
 * Формат ввода
 * В первой строке вводится число дней n (1 ≤ n ≤ 100000).
 * Во второй строке вводится n чисел — цены за 1000 кубометров газа в каждый из
 * дней. Цена — целое число от 1 до 5000. Дни нумеруются с единицы.
 *
 * Формат вывода
 * Выведите два числа i и j — номера дней для покупки и продажи газа. Если прибыль
 * получить невозможно, выведите два нуля.
 *
 * Пример 1
 * Ввод
 * 6
 * 10 3 5 3 11 9
 * Вывод
 * 2 5
 *
 * Пример 2
 * Ввод
 * 4
 * 5 5 5 5
 * Вывод
 * 0 0
 */
class TaskC1 {
    private val scan = java.util.Scanner(System.`in`)
    private val countDay = scan.nextLine().toInt()
    private val priceDays = scan.nextLine().split(" ")

    init {
        var bestBuyDay = 0
        var bestSellDay = 0
        var minCostDay = 0
        val arrayPriceDay = priceDays.map { it.toInt() }
        for (i in 0..arrayPriceDay.lastIndex) {
            if (arrayPriceDay[bestSellDay] * arrayPriceDay[minCostDay] < arrayPriceDay[bestBuyDay] * arrayPriceDay[i]) {
                bestBuyDay = minCostDay
                bestSellDay = i
            }
            if (arrayPriceDay[i] < arrayPriceDay[minCostDay]) {
                minCostDay = i
            }
        }
        if (bestSellDay == bestBuyDay) {
            print("0 0")
        } else {
            print("${bestBuyDay + 1} ${bestSellDay + 1}")
        }
    }
}