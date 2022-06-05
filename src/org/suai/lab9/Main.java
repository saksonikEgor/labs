package org.suai.lab9;

import java.util.Scanner;

public class Main {
    public static void test1(){
        var a = new Object();
        var b = new Object();

        var th1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("for 1 thread: holdLock(a) == " + Thread.holdsLock(a) + ", holdLock(b) == " + Thread.holdsLock(b));

                synchronized (b) {
                    System.out.println("1 thread in B");
                }
            }
        });

        var th2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("for 2 thread: holdLock(a) == " + Thread.holdsLock(a) + ", holdLock(b) == " + Thread.holdsLock(b));

                synchronized (a) {
                    System.out.println("2 thread in A");
                }
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //test1();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        InternetCafe cafe = new InternetCafe(n, m, 10000);

        try {
            cafe.go();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
