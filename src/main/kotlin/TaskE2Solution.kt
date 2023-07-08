/**
Дан массив a из n чисел. Найдите минимальное количество чисел, после удаления которых попарная разность оставшихся
чисел по модулю не будет превышать 1, то есть после удаления ни одно число не должно отличаться от какого-либо
другого более чем на 1.
Формат ввода
Первая строка содержит одно целое число n(1≤n≤2x10e5) — количество элементов массива a.
Вторая строка содержит n целых чисел a1, a2, … , an(0≤ai≤10e5) — элементы массива a.

Формат вывода
Выведите одно число — ответ на задачу.
Пример 1
Ввод
5
1 2 3 4 5
Вывод
3
Пример 2
Ввод
10
1 1 2 3 5 5 2 2 1 5
Вывод
4
 */
class TaskE2Solution {
    private val sizeArray = readln().toInt()
    private val array = readln().split(" ")
    private val map: HashMap<Int, Int> = hashMapOf()

    init {
        var count = 0

        array.forEach {
            val key = it.toInt()
            if (map[key] != null) {
                map[key] = map[key]!! + 1
            } else {
                map[key] = 1
            }
        }

        map.keys.forEach { key ->
            val value = if (map[key] != null) {
                map[key]!!
            } else {
                0
            }
            count = maxOf(
                a = count,
                b = value + if (map[key + 1] != null) {
                    map[key + 1]!!
                } else {
                    0
                },
                c = value + if (map[key - 1] != null) {
                    map[key - 1]!!
                } else {
                    0
                },
            )
        }
        print(sizeArray - count)
    }
}