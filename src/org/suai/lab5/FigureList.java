package org.suai.lab5;

import java.util.LinkedList;
import java.util.ListIterator;

public class FigureList {
    protected final LinkedList<Figure> scheme;

    public FigureList(){
        scheme = new LinkedList<Figure>();
    }

    public void addToHead(Figure figure){
        scheme.addFirst(figure);

    }

    public boolean findFigure(int id){
        for (Figure n : this.scheme) {
            if (id == n.getId()) {
                return true;
            }
        }
        return false;
    }

    public void erase(int id){
        ListIterator<Figure> it = this.scheme.listIterator();
        while (it.hasNext()) {
            Figure n = it.next();
            if (id == n.getId()) {
                it.remove();
                return;
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Figure n : this.scheme) {
            sb.append(n.toString()).append("\n");
        }
        return sb.toString();
    }

    public void printAll(){
        System.out.println(this);
    }
}
