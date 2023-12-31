/**
Площадка для выгула собак — место, где собираются и общаются люди разных возрастов. На одной из площадок
Восточного Бирюлева хозяева собак очень дружны и приглашают друг-друга на день рождения.
Человек x не приглашает на день рождения человека y если выполнено хотя бы одно из условий:
- (Возраст человека y) <= 0.5 * (Возраст человека x) + 7
- (Возраст человека y) > (Возраст человека x)
- (Возраст человека y) > 100 и одновременно с этим (Возраст человека x) < 100

Во всех остальных случаях человек x приглашает человека y на день рождения.
Определите суммарное количество приглашений на день рождения.

Формат ввода
В первой строке вводится число n (1 ≤ n ≤ 100_000).

Во второй строке вводится n чисел — возраст людей. Возраст находится в промежутке от 1 до 120.

Формат вывода
Выведите одно число — суммарное количество приглашений.

Пример 1
Ввод
2
16 16
Вывод
2
Пример 2
Ввод
3
17 16 18
Вывод
2
Пример 3
Ввод
5
120 25 30 100 105
Вывод
4
 */
class TaskB3 {
    private val sizeList = readln().toInt()
    private val list = readln().split(" ")
        .map { it.toInt() }
        .sorted()


    init {
        var answer = 0
        var start = 0
        var end = 0
        for (i in 0..list.lastIndex) {
            while (start <= list.lastIndex && list[start] <= (0.5 * list[i]) + 7){
                start += 1
            }
            while (end <= list.lastIndex && list[end] <= list[i]) {
                end += 1
            }
            if (end > start + 1) {
                answer += end - start - 1
            }
        }
        print(answer)
    }
}