package org.suai.lab7;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Graph graph = new Graph(5);

        try {
            graph.loadFromTextFile("/Users/egor/Desktop/input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(graph);

        try {
            graph.saveToTextFile("/Users/egor/Desktop/output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
