# Читатели-писатели.
Написать класс стек на основе cвязного списка (классом LinkedList пользоваться нельзя) с методами
### модифицирующими: void push(int), int pop()
### читающими: equals, toString
Класс должен быть пригоден к использованию в многопоточных программах. Написать две реализации:
### SynchroStack --- со стеком одновременно работать может только один поток
### SynchroStackFast --- со стеком одновременно может работать либо один модифицирующий поток, либо несколько читающих потоков

В main с помощью замеров времени показать преимущество SynchroStackFast при работе в многопоточной программе.

# Доп. задание

Реализуйте класс IterativeParallelism, который будет обрабатывать списки в несколько потоков.
Должны быть реализованы следующие методы:

— вернуть первый минимум из списка
```
T minimum(int threads, List<? extends T> list, Comparator<? super T> comparator) 
```
— вернуть первый максимум
```
T maximum(int threads, List<? extends T> list, Comparator<? super T> comparator) 
```
— проверка, что все элементы списка удовлетворяют предикату
```
boolean all(int threads, List<? extends T> list, Predicate<? super T> predicate)
```
— проверка, что существует элемент списка, удовлетворяющий предикату
```
boolean any(int threads, List<? extends T> list, Predicate<? super T> predicate)
```
— вернуть список, содержащий элементы, удовлетворяющие предикату
```
List<T> filter(int threads, List<? extends T> list, Predicate<? super T> predicate)
```
— вернуть список, содержащий результаты применения функции
```
List<U> map(int threads, List<? extends T> list, Function<? super T, ? extends U> function)
```
— конкатенация строковых представлений элементов списка
```
String join(int threads, List<?> list)
```
```
Comparator, Predicate, Function — интерфейсы стандартной библиотеки
```
Во все функции передается параметр threads — сколько потоков надо использовать при вычислении. Вы можете рассчитывать, что число потоков не велико.  
Не следует рассчитывать на то, что переданные компараторы, предикаты и функции работают быстро.  
При выполнении задания нельзя использовать Concurrency Utilities.  
