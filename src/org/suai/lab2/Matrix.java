package org.suai.lab2;

public class Matrix {

    private int[][] matrix;
    private int n;

    public Matrix(int n){
        matrix = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = 1;
            }
        }
        this.n = n;
    }

    public Matrix sum(Matrix m){
        Matrix res = new Matrix(n);
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                res.matrix[i][j] = m.matrix[i][j] + matrix[i][j];
            }
        }
        return res;
    }

    public Matrix product(Matrix m){
        Matrix res = new Matrix(n);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                res.matrix[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    res.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return res;
    }

    public void setElement(int row, int column, int value){
        matrix[row][column] = value;
    }

    public int getElement(int row, int column){ return matrix[row][column]; }

    public String toString(){
        StringBuilder sb = new StringBuilder(this.n * this.n * 2);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.n; j++){
                sb.append(this.matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
/*
    public void doGauss(){
        for (int j = 0; j < this.n - 1; j++) {
            for (int i = j + 1; i < this.n; i++) {
                if(this.matrix[j][j] == 0)
                    throw new RuntimeException("диагональный элемент равен нулю");
                double cur = this.matrix[i][j] / this.matrix[j][j];
                for (int k = 0; k < this.n; k++) {
                    this.matrix[i][k] = this.matrix[i][k] - (cur * this.matrix[j][k]);
                }
            }
        }
    }

 */

    public static void main(String[] args){
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.setElement(1,1,0);
        m2.setElement(1,1,0);
        System.out.println(m1);
        for(int i = 0; i < 9; i++) {
            m1 = m1.product(m2);
            System.out.println(m1);
        }
    }
}