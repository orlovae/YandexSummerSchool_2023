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
class TaskC {
    private val scan = java.util.Scanner(System.`in`)
    private val sizeArray = scan.nextLine().toInt()
    private val arrayPriceString = scan.nextLine().split(" ")
//    private val arrayPrice : Map<Int, Int> = arrayPriceString.associateWith {  }

    init {
//        println(arrayPrice)
    }

    private fun getDay(arrayProce: List<Int>): String {

//        arrayProce.maxBy {  }
    return ""
    }

}