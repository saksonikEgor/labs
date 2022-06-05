package org.suai.lab3;

public class Matrix {

    protected int [][] matrix;
    protected int row;
    protected int col;

    public Matrix(int row, int col){
        if(row < 0 || col < 0){
            throw new MyException("ошибка в конструкторе");
        }
        matrix = new int[row][col];
        this.row = row;
        this.col = col;
    }

    public void setElement(int row, int col, int val){
        if(row < 0 || col < 0 || row >= this.row || col >= this.col)
            throw new BadRangeMatrixException("ошибка в сеттере");
        matrix[row % matrix.length][col] = val;
    }

    public int getElement(int row, int col){
        if(row < 0 || col < 0 || row >= this.row || col >= this.col)
            throw new BadRangeMatrixException("ошибка в геттере");
        return matrix[row % matrix.length][col];
    }

    public Matrix sum(Matrix m){
        if(m.row != this.row || m.col != this.col)
            throw new NonSuitableMatrixException("некорректные размеры матриц для сложения");
        Matrix res = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res.matrix[i % res.matrix.length][j] = m.matrix[i % m.matrix.length][j] + matrix[i % this.matrix.length][j];
            }
        }
        return res;
    }

    public Matrix product(Matrix m){
        if(this.col != m.row)
            throw new NonSuitableMatrixException("некорректные размеры матриц для умножения");
        Matrix res = new Matrix(this.row, m.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < m.col; j++) {
                for (int k = 0; k < this.col; k++) {
                    res.matrix[i % res.matrix.length][j] += this.matrix[i % this.matrix.length][k] * m.matrix[k % m.matrix.length][j];
                }
            }
        }
        return res;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(row * col * 2);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sb.append(this.matrix[i % matrix.length][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int hashCode(){
        final int prime = 37;
        int result = 17;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result = prime * result + matrix[i % matrix.length][j];
            }
        }
        return result;
    }

    public boolean equals(Matrix m){
        if(this.hashCode() != m.hashCode())
            return false;
        if(this == m)
            return true;
        if((m == null) || (getClass() != m.getClass()) || ((this.row != m.row) || (this.col != m.col)))
            return false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(this.matrix[i % this.matrix.length][j] != m.matrix[i % m.matrix.length][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int row = 2;
        int col = 4;

        //MirrorMatrixHor mirror1 = new MirrorMatrixHor(row, col);
        //MirrorMatrixHor mirror2 = new MirrorMatrixHor(row, col);
        Matrix matrix1 = new Matrix(row * 2, col);
        Matrix matrix2 = new Matrix(row, col);
        SquareMatrix sqMatrix1 = new SquareMatrix(row);
        SquareMatrix sqMatrix2 = new SquareMatrix(col);
        /*

        mirror1.setElement(1,2,3);
        mirror1.setElement(1,1,4);

        mirror2.setElement(0,0,3);
        mirror2.setElement(0,1,4);
        mirror2.setElement(3,3,10);
        mirror2.setElement(3,2,15);
        */

        matrix1.setElement(1,0,8);
        matrix1.setElement(1,3,16);
        matrix1.setElement(1,2,8);
        matrix1.setElement(1,1,16);

        matrix2.setElement(1,0,11);
        matrix2.setElement(1,3,1);
        matrix2.setElement(0,2,200);
        matrix2.setElement(0,1,99);

        sqMatrix1.setElement(0,0,5);
        sqMatrix1.setElement(0,1,11);
        sqMatrix1.setElement(1,0,103);
        sqMatrix1.setElement(1,1,155);

        sqMatrix2.setElement(0,0,3);
        sqMatrix2.setElement(0,1,4);
        sqMatrix2.setElement(3,3,10);
        sqMatrix2.setElement(3,2,15);

        System.out.println("matrix1: \n" + matrix1 + "\n" + "matrix2: \n" + matrix2 + "\n" + "sqMatrix1: \n"  + sqMatrix1 + "sqMatrix2: \n"  + sqMatrix2);
        System.out.println("sqMatrix2 + matrix1: \n" + sqMatrix2.sum(matrix1));
        System.out.println("matrix1 * sqMatrix2: \n" + matrix1.product(sqMatrix2));
        System.out.println("matrix2 * sqMatrix2: \n" + matrix2.product(sqMatrix2));
        System.out.println(sqMatrix1.equals(sqMatrix2));
    }
}