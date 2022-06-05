package org.suai.lab5;

public class Figure{

    private static int globalId = 0;
    protected int id;
    protected UsualMatrix matrix;
    protected int numberOfDots;

    public Figure(int numberOfDots){
        matrix = new UsualMatrix(numberOfDots, 2);
        id = getNextId();
    }

    private static int getNextId() {
        return globalId++;
    }

    public void addDot(int x, int y){
        if(numberOfDots >= matrix.getRow())
            throw new MyException("вы ввели слишком много точек для данной фигуры");
        matrix.setElement(numberOfDots, 0, x);
        matrix.setElement(numberOfDots, 1, y);
        numberOfDots++;
    }

    public final void setId(int id){
        this.id = id;
    }

    public final int getId(){
        return id;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("index:\n").append(this.getId()).append("\n");
        sb.append("matrix:\n").append(matrix.toString()).append("\n");
        return sb.toString();
    }
}
