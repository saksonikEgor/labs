/*
ОСНОВНОЕ ЗАДАНИЕ:
Напишите класс, реализующий «правильные с объектно-ориентированной точки зрения целые числа”, В классе должны быть определены

методы  increment() и decrement(), соответственно увеличивающие и уменьшающие число на 1;
методы add(Int n) и substract(Int n), увеличивающие и уменьшающие число на n;
метод 	toString()

Примечание 1: в методах add и substract передаются значения типа Int (с большой буквы), а не int.
Примечание 2: для сдачи основного задания нельзя придумывать свои методы и конструкторы, нужно использовать указанные выше.
Примечание 3: применить инкрементирование 1000 раз - плохой вариант.
Примечание 4: в доп. задании можно создать конструктор Int(int value).

При создании нового объекта должно создаваться число, равное 0.

Напишите наиболее короткую программу, которая используя только класс Int, выводит на экран число 1000. Программа должна быть чисто объектно-ориентированной. В частности, в ней нельзя использовать оператор присваивания.

ДОПОЛНИТЕЛЬНОЕ ЗАДАНИЕ:
в класс Int дописать метод бинарного возведения в степень и его две версии:

1) binPowMemo — с мемоизацией
2) binPowIterative — нерекурсивную

и посчитать сложность по времени и по памяти всех трех алгоритмов
/*


package org.suai.lab1;

public class Int {

    int a;
    public static Int [][] memory;//матрица [n][k] содержит значения при возведении в степень n^k
    //например memory[2][3] = 2^3 = 8

    public Int(){
        this.a = 0;
    }

    public Int(int n){
        this.a = n;
    }

    public void increment(){
        this.a++;
    }

    public void decrement(){
        this.a--;
    }

    public void add(Int n){
        this.a = this.a + n.a;
    }

    public void substract(Int n){
        this.a = this.a - n.a;
    }

    public String toString(){
        String s = new String();
        s += this.a;
        return s;
    }

    public Int binPow(int n){
        Int cur;
        if (n == 0) {
            cur = new Int(1);
            return cur;
        }
        if (n % 2 == 1) {
            cur = new Int(this.a);
            cur.a = cur.binPow(n - 1).a * this.a;
            return cur;
        }
        else {
            cur = new Int(this.a);
            cur.a = cur.binPow(n / 2).a;
            cur.a = cur.a * cur.a;
            return cur;
        }
    }

    public Int binPowIterative(int n){
        Int cur = new Int(this.a);
        for(int i = 1; i < n; i++){
            cur.a = cur.a * this.a;
        }
        return cur;
    }

    public static Int binPowMemo(Int a, int n){//
        if(memory[a.a][n].a == 0){//Проверяем, находили ли мы данное значение
            memory[a.a][n].a = a.binPow(n).a; //Если нет, то находим и записываем в таблицу
        }
        return memory[a.a][n];
    }

    public static Int binPowMemoIterative(Int a, int n){
        if(memory[a.a][n].a == 0){//Проверяем, находили ли мы данное значение
            memory[a.a][n].a = a.binPowIterative(n).a; //Если нет, то находим и записываем в таблицу
        }
        return memory[a.a][n];
    }

    public static long mem() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static void main(String[] args){
        Int dig1 = new Int();
        dig1.increment();
        for(int i = 0; i < 7; i++)
            dig1.add(dig1);
        for(int i = 0; i < 3; i++)
            dig1.decrement();
        for(int i = 0; i < 3; i++)
            dig1.add(dig1);
        System.out.println(dig1);
    }
}
