/**
 * Для компилятора яндекса надо копировать main и нужный class
 */
fun main(args: Array<String>) {
    val sizeArray = readln().toInt()
    val array = readln().split(" ")
    val map: HashMap<Int, Int> = hashMapOf()

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