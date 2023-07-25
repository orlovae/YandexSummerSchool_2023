/**
В университете есть n аудиторий и m учебных групп. Для каждой аудитории задана её вместимость, а для каждой группы
— численность. Группа может заниматься в аудитории только если её численность не превосходит размера аудитории.
Определите максимальное количество групп, которые можно рассадить по аудиториям.

Формат ввода
В первой строке вводится число n (1 ≤ n ≤ 100_000).
Во второй строке вводится n чисел — численность групп. Численность не превосходит 100_000.
В третьей строке вводится число m (1 ≤ m ≤ 100_000).
В четвертой строке вводится m чисел — вместимость аудиторий. Вместимость не превосходит 100_000.

Формат вывода
Выведите ответ на задачу.

Пример 1
Ввод
3 - количество групп
3 1 2 - численность групп
2 - количество аудиторий
1 1 - вместимость аудиторий
Вывод
1
Пример 2
Ввод
2
1 2
3
3 2 1
Вывод
2
https://contest.yandex.ru/contest/50523
 */
class TaskA4Solution {
    private val sizeGroupList = readln().trim().toInt()
    private val groupList = readln()
        .trim()
        .split(" ")
        .map { it.toInt() }
        .sortedDescending()
    private val sizeAuditoriumList = readln().trim().toInt()
    private val capacityAuditoriumList = readln()
        .trim()
        .split(" ")
        .map { it.toInt() }
        .sortedDescending()

    init {
        var answer = 0

        var startGroup = 0
        var startAuditorium = 0
        while (startAuditorium <= sizeAuditoriumList - 1 && startGroup <= sizeGroupList - 1) {
            if (capacityAuditoriumList[startAuditorium] >= groupList[startGroup]) {
                answer += 1
                startAuditorium++
                startGroup++
            } else {
                startGroup++
            }
        }

        print(answer)
    }
}
