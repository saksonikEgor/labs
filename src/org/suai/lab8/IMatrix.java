package org.suai.lab8;

public interface IMatrix{

    int getElement(int row, int col);

    void setElement(int row, int col, int val);

    Matrix sum(IMatrix m);

    Matrix product(IMatrix m);

    String toString();

    public int getRow();

    public int getCol();
}
