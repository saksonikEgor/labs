package org.suai.lab8;

public class Item {
    private int weigth;
    private int price;

    public Item(int weigth, int price) {
        this.weigth = weigth;
        this.price = price;
    }

    public int getWeigth() {
        return this.weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        var res = new StringBuilder();
        res.append("weigth: ").append(weigth).append(" price: ").append(price);
        return res.toString();
    }
}
