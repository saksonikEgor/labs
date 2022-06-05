package org.suai.lab5;

public class Segment extends Figure{
    UsualMatrix start;
    UsualMatrix end;

    public Segment(int numberOfDots){
        super(numberOfDots);
        start = new UsualMatrix(1,2);
        end = new UsualMatrix(1,2);
    }

    public void addDot(int x, int y){
        if(numberOfDots >= matrix.getRow())
            throw new MyException("вы ввели слишком много точек для данной фигуры");

        matrix.setElement(numberOfDots, 0, x);
        matrix.setElement(numberOfDots, 1, y);
        numberOfDots++;
        if(numberOfDots == 1){
            this.start.setElement(0,0, x);
            this.start.setElement(0,1, y);
        }
        if(numberOfDots == this.matrix.getRow()){
            this.end.setElement(0,0, x);
            this.end.setElement(0,1, y);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass()).append("\n");
        sb.append("index:\n").append(this.getId()).append("\n");
        sb.append("matrix:\n").append(matrix.toString());
        sb.append("start:\n").append(this.start.toString());
        sb.append("end:\n").append(this.end.toString());
        return sb.toString();
    }
}
