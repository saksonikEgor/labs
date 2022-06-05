package org.suai.lab8;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> bestItems;
    private final int MAX_WEIGTH;
    private int bestPrice;

    public Backpack(int maxWeigth) {
        bestItems = new ArrayList<>();
        MAX_WEIGTH = maxWeigth;
    }

    private int calcWeigth(ArrayList<Item> items) {
        int sumW = 0;

        for (Item i : items)
            sumW += i.getWeigth();

        return sumW;
    }

    private int calcPrice(ArrayList<Item> items) {
        int sumPrice = 0;

        for (Item i : items)
            sumPrice += i.getPrice();

        return sumPrice;
    }

    private void checkSet(ArrayList<Item> items) {
        if (calcWeigth(items) <= MAX_WEIGTH && calcPrice(items) > bestPrice) {
            bestItems = items;
            bestPrice = calcPrice(items);
        }
    }

    public void makeAllSets(ArrayList<Item> items) {
        if (items.size() > 0)
            checkSet(items);

        for (int i = 0; i < items.size(); i++) {
            ArrayList<Item> newItems = new ArrayList<>(items);
            newItems.remove(i);
            makeAllSets(newItems);
        }
    }

    public void uniteBags(Backpack bag) {
        this.bestItems.addAll(bag.bestItems);
    }

    public ArrayList<Item> getBestItems() {
        return this.bestItems;
    }

    public int getMaxWeigth() {
        return this.MAX_WEIGTH;
    }

    public int getBestPrice() {
        return this.bestPrice;
    }
}





















