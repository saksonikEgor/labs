package org.suai.lab8;

import java.util.ArrayList;

public class KnapsackThread extends Thread{
    private ArrayList<Item> items;
    private Backpack bag;
    private int begin;
    private int end;

    KnapsackThread(Backpack bag, ArrayList<Item> items, int begin, int end) {
        this.items = items;
        this.bag = bag;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        ArrayList<Item> curItems = new ArrayList<>();

        for (int i = begin; i < end; i++)
            curItems.add(items.get(i));

        bag.makeAllSets(curItems);
    }

    public Backpack getBag() {
        return this.bag;
    }
}
