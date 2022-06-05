package org.suai.lab3;

import org.suai.lab3.Matrix;

public class SquareMatrix extends Matrix {

    private final int size;

    public SquareMatrix(int n){
        super(n, n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                this.setElement(i, j, 1);
            }
        }
        size = n;
    }

    public SquareMatrix sum(SquareMatrix sm) {
        if(this.size != sm.size)
            throw new MyException("матрицы разных размеров");
        SquareMatrix res = new SquareMatrix(sm.size);
        for (int i = 0; i < sm.size; i++){
            for (int j = 0; j < sm.size; j++){
                res.matrix[i][j] = sm.matrix[i][j] + this.matrix[i][j];
            }
        }
        return res;
    }

    public SquareMatrix product(SquareMatrix sm){
        if(this.size != sm.size){
            throw new MyException("матрицы разных размеров");
        }
        SquareMatrix res = new SquareMatrix(sm.size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    res.matrix[i][j] += this.matrix[i][k] * sm.matrix[k][j];
                }
            }
        }
        return res;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(size * size * 2);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sb.append(this.matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int hashCode(){
        final int prime = 37;
        int result = 17;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                result = prime * result + matrix[i][j];
            }
        }
        return result;
    }

    public boolean equals(SquareMatrix sm){
        if(this.hashCode() != sm.hashCode())
            return false;
        if(this == sm)
            return true;
        if((sm == null) || (getClass() != sm.getClass()) || this.size != sm.size)
            return false;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(this.matrix[i][j] != sm.matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}