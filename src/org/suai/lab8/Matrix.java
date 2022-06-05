package org.suai.lab8;

import java.util.Random;

public abstract class Matrix implements IMatrix {
    protected final int row;
    protected final int col;

    protected Matrix(int row, int col) {
        if (row < 1 || col < 1) {
            throw new MyException("ошибка в костнтурторе");
        }
        this.row = row;
        this.col = col;
    }

    protected abstract Matrix getInstance(int row, int col);

    public abstract void setElement(int row, int col, int val);

    public abstract int getElement(int row, int col);

    public final Matrix sum(IMatrix m) {
        if (this.row != m.getRow() || this.col != m.getCol())
            throw new MyException("некорректные размеры матриц для сложения");
        Matrix res = getInstance(this.row, this.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res.setElement(i, j, m.getElement(i, j) + this.getElement(i, j));
            }
        }
        return res;
    }

    public final Matrix product(IMatrix m) {
        if (this.col != m.getRow())
            throw new MyException("некорректные размеры матриц для умножения");

        Matrix res = getInstance(this.row, m.getCol());

        for (int i = 0; i < res.row; i++)
            for (int j = 0; j < res.col; j++)
                for (int k = 0; k < this.col; k++)
                    res.setElement(i, j, res.getElement(i, j) + this.getElement(i, k) * m.getElement(k, j));

        return res;
    }

    public final void randomize(int limit) {
        Random rand = new Random();

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.setElement(i, j, rand.nextInt(limit));
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(row * col * 2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(this.getElement(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public final int hashCode() {
        final int prime = 37;
        int result = 17;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = prime * result + this.getElement(i, j);
            }
        }
        return result;
    }

    public final boolean equals(Object m) {
        if (this == m)
            return true;
        if ((m == null) || !(m instanceof Matrix))
            return false;
        Matrix other = (Matrix) m;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (this.getElement(i, j) != other.getElement(i, j))
                    return false;
            }
        }
        return true;
    }

    public final int getRow() {
        return this.row;
    }

    public final int getCol() {
        return this.col;
    }
}