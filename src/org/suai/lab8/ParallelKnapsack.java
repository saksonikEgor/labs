package org.suai.lab8;

import java.util.ArrayList;

public class ParallelKnapsack {
    private final ArrayList<KnapsackThread> threads;
    private final int numOfThreads;
    private final int MAX_WAIGTH;

    public ParallelKnapsack(int numOfThreads, int MAX_WAIGTH) {
        this.numOfThreads = numOfThreads;
        this.threads = new ArrayList<>();
        this.MAX_WAIGTH = MAX_WAIGTH;
    }

    public ArrayList<Item> solveKnapsak(ArrayList<Item> items) throws InterruptedException {
        int begin = 0;
        int part = Math.round((float) items.size() / numOfThreads);
        int end = part;

        for (int i = 1; i < numOfThreads; i++) {
            Backpack bag = new Backpack(MAX_WAIGTH);
            KnapsackThread th = new KnapsackThread(bag, items, begin, end);
            th.start();
            this.threads.add(th);

            begin = end;
            end += part;
        }

        end = items.size();

        Backpack bag = new Backpack(MAX_WAIGTH);
        var remainder = new KnapsackThread(bag, items, begin, end);
        remainder.start();
        this.threads.add(remainder);

        for (var th : this.threads)
            th.join();

        Backpack bestBag = new Backpack(MAX_WAIGTH);

        for (var th : this.threads) {
            bestBag.uniteBags(th.getBag());
        }

        bestBag.makeAllSets(bestBag.getBestItems());
        return bestBag.getBestItems();
    }
}










