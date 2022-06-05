package org.suai.lab5;

import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix extends Matrix{
    protected final LinkedList<Element> matrix;

    public SparseMatrix(int row, int col) {
        super(row, col);
        this.matrix = new LinkedList<Element>();
    }

    protected Matrix getInstance(int row, int col) {
        return new SparseMatrix(row, col);
    }

    public void setElement(int row, int col, int val) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col)
            throw new MyException("ошибка в сеттере");
        ListIterator<Element> it = this.matrix.listIterator();
        while (it.hasNext()) {
            Element n = it.next();
            if (n.checkPosition(row, col)) {
                if (val == 0) {
                    it.remove();
                    return;
                }
                n.setValue(val);
                return;
            }
        }
        if (val == 0)
            return;
        this.matrix.add(new Element(row, col, val));
    }

    public int getElement(int row, int col) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col)
            throw new MyException("ошибка в геттере");
        for (Element n : this.matrix) {
            if (n.checkPosition(row, col))
                return n.getValue();
        }
        return 0;
    }

    private static class Element{
        int row;
        int col;
        int value;

        Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        boolean checkPosition(int row, int col) {
            return this.row == row && this.col == col;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }
}