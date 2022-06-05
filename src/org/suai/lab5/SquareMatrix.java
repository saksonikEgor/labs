package org.suai.lab5;

public class SquareMatrix extends Matrix {
    protected final int [][] matrix;

    public SquareMatrix(int n){
        super(n, n);
        matrix = new int[row][col];
    }

    protected Matrix getInstance(int row, int col) {
        if(row != col)
            throw new MyException("такая матрица не мродет называться квадратной");
        return new SquareMatrix(row);
    }

    public void setElement(int row, int col, int val){
        if(row < 0 || col < 0 || row >= this.row || col >= this.col)
            throw new MyException("ошибка в сеттере");
        matrix[row][col] = val;
    }

    public int getElement(int row, int col){
        if(row < 0 || col < 0 || row >= this.row || col >= this.col)
            throw new MyException("ошибка в геттере");
        return matrix[row][col];
    }
}
