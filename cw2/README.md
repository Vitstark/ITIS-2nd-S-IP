# 1

Написать тесты для метода `List<Integer> method(List<Integer> list, int n)` класса `ToTest`,
который получает список чисел и возвращает список из частичных сумм `n` последних элементов.

Под частичными суммами понимается: 1, первый элемент, суммы первого и второго, суммы первого, второго и третьего и т.д., суммы первых `n` элементов. Для списка `[1,2,3,4,5,6]` частичные суммы 3 последних элементов будут `[0,4,9,15]`.

Если какой-то элемент списка равен `null`, все суммы, в которые он входит, равны `null`.

Если весь список равен `null`, метод выбрасывает исключение `NullPointerException`

# 2

В файле `input.txt` в каждой строке содержатся числа, разделенные пробелами.

Если в строке ровно одно число `N`, скачайте изображение по адресу `https://cataas.com/cat/gif` в файл `N.gif`. 

Если в строке другое количество чисел, запишите эти числа в файл `wrong.txt`

Для скачивания можно получить `InputStream` следующим образом:
```
InputStream is = new URL("https://site.address/something").openStream();
```

Решение должно быть в методе `void task2() throws IOException`

# 3

В файле `dir.txt` единственная строка - путь к директории.

В этой директории и её поддиректориях глубины не больше 2 посчитайте суммарный объём файлов, название которых начинается с `lib` (например, `libgmp.so`).

Решение должно быть в методе `int task3() throws IOException`
