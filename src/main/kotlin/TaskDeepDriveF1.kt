/**
У рекламного агентства есть большой баннерный экран с разрешением n пикселей в высоту и m пикселей в ширину.
Каждый пиксель представляет собой три лампочки: одна синего цвета, одна - красного и одна - желтого цветов.
Лампочки могут зажигаться как по отдельности, так и одновременно. Если зажглась лампочка:
- синего цвета, то пиксель будет синий (B);
- красного цвета — красный (R);
- желтого цвета — желтый (Y);
- синего и красного цветов — фиолетовый (P);
- синего и желтого цветов — зеленый (G);
- желтого и красного цветов — оранжевый (O);
- синего, желтого и красного цветов — бордовый (V).
Если не включить ни одну лампочку, то будет отображаться черный цвет (D). Фирма получила заказ — отобразить одно
рекламное объявление. К сожалению, не все лампочки работают, так как некоторые из них перегорели. Помогите понять,
сможет ли фирма отобразить это объявление без искажений.

Формат ввода
В первой строке содержится два числа: 1≤n,m≤100. В следующих n строках содержится ровно m символов 0 и 1,
обозначающих, что в этом пикселе: 0 — перегорела синяя лампочка, 1 — синяя лампочка работает. В следующих n строках
также содержится ровно m символов 0 и 1, обозначающих, что в этом пикселе: 0 — перегорела красная лампочка, 1 —
красная лампочка работает. В следующих n строках содержится ровно m символов 0 и 1, обозначающих что в этом пикселе:
0 — перегорела жёлтая лампочка, 1 — жёлтая лампочка работает. В последних n строках содержится ровно m символов,
обозначающих цвета (расшифровка дана в списке выше).
Формат вывода
По заданному состоянию рекламного баннера выведите «Yes», если получится отобразить эту рекламу, «No» — если не
получится.
Пример 1
Ввод
1 1
0
0
0
B
Вывод
NO
Пример 2
Ввод
1 1
0
0
0
D
Вывод
YES
 */
class TaskDeepDriveF1 {
}