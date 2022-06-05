package org.suai.lab7;

public interface IMatrix{

    int getElement(int row, int col);

    void setElement(int row, int col, int val);

    Matrix sum(IMatrix m);

    Matrix product(IMatrix m);

    String toString();

    public int getRow();

    public int getCol();
}
