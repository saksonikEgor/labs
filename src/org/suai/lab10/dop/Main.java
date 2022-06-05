package org.suai.lab10.dop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IterativeParallelism iP = new IterativeParallelism();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            list.add(5);
            list.add(4);
            list.add(3);
            list.add(2);
            list.add(1);
            list.add(8);
            list.add(7);
            list.add(675);
            list.add(4);
        }

        list.add(0);


        long start;
        long finish;


        for (int i = 1; i < 5; i++) {
            System.out.print(i + " threads: ");

            int resMin = 0;

            start = System.currentTimeMillis();

            try {
                resMin = iP.minimum(i, list, Integer::compareTo);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            finish = System.currentTimeMillis();

            System.out.println(finish - start + "ms, result: " + resMin);
        }

        for (int i = 1; i < 5; i++) {
            System.out.print(i + " threads: ");

            int resMax = 0;

            start = System.currentTimeMillis();

            try {
                resMax = iP.maximum(i, list, Integer::compareTo);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            finish = System.currentTimeMillis();

            System.out.println(finish - start + "ms, result: " + resMax);
        }

        for (int i = 1; i < 5; i++) {
            System.out.print(i + " threads: ");

            String res = "";

            start = System.currentTimeMillis();

            try {
                res = iP.join(i, list);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            finish = System.currentTimeMillis();

            System.out.println(finish - start + "ms, result: " + res);
        }
    }
}
