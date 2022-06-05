package org.suai.lab5;

public class Circle extends Figure{
    int radius;

    public Circle(int numberOfDots){
        super(numberOfDots);
    }

    public void setRadius(int radius){
        if(radius < 0)
            throw new MyException("вы ввели некорректный радиус фигуры Circle");
        this.radius = radius;
    }

    public int getRadius(){
        return this.radius;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass()).append("\n");
        sb.append("index:\n").append(this.getId()).append("\n");
        sb.append("matrix\n").append(matrix.toString());
        sb.append("radius:\n").append(this.getRadius()).append("\n");
        return sb.toString();
    }
}
