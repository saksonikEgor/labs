package org.suai.lab8;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            test1();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void test2() throws InterruptedException {
        long start;
        long finish;

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(6, 5));
        items.add(new Item(4, 3));
        items.add(new Item(3, 1));
        items.add(new Item(2, 3));
        items.add(new Item(3, 6));
        items.add(new Item(8, 6));
        items.add(new Item(5, 2));
        items.add(new Item(15, 6));
        items.add(new Item(6, 5));






        Backpack singleBag = new Backpack(15);
        singleBag.makeAllSets(items);

        var singleResult = singleBag.getBestItems();


        for (int numOfThreads = 1; numOfThreads <= 4; numOfThreads++) {
            System.out.print(numOfThreads + " threads: ");

            start = System.currentTimeMillis();

            ParallelKnapsack pk = new ParallelKnapsack(numOfThreads, 15);
            var res2 = pk.solveKnapsak(items);
            finish = System.currentTimeMillis();

            System.out.println(finish - start + "ms  " + res2.equals(singleResult));
            //System.out.println(res2);
        }
    }

    public static void test1() throws InterruptedException {
        int size = 1000;
        UsualMatrix m1 = new UsualMatrix(size, size);
        UsualMatrix m2 = new UsualMatrix(size, size);
        m1.randomize(100);
        m2.randomize(100);
        long start;
        long finish;


        UsualMatrix singleRes = (UsualMatrix) m1.product(m2);

        //System.out.println(singleRes);

        for (int numOfThreads = 1; numOfThreads <= 10; numOfThreads++) {
            System.out.print(numOfThreads + " threads: ");

            start = System.currentTimeMillis();
            ParallelMatrixProduct pmp = new ParallelMatrixProduct(numOfThreads);
            UsualMatrix res2 = pmp.product(m1, m2);
            finish = System.currentTimeMillis();

            System.out.println(finish - start + "ms  " + res2.equals(singleRes));
            //System.out.println(res2);
        }
    }
}
