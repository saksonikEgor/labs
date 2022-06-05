package org.suai.lab5;

public class UsualMatrix extends Matrix{
    protected final int [][] matrix;

    public UsualMatrix(int row, int col){
        super(row, col);
        matrix = new int[row][col];
    }

    protected Matrix getInstance(int row, int col) {
        return new UsualMatrix(row, col);
    }

    public final void setElement(int row, int col, int val){
        if(row < 0 || col < 0 || row >= this.row || col >= this.col)
            throw new MyException("ошибка в сеттере");
        matrix[row][col] = val;
    }

    public final int getElement(int row, int col){
        if(row < 0 || col < 0 || row >= this.row || col >= this.col)
            throw new MyException("ошибка в геттере");
        return matrix[row][col];
    }

}
