package org.suai.lab7;

import java.io.*;

public class Graph {
    private final UsualMatrix matrix;
    private final int size;

    public Graph (int size) {
        this.size = size;
        this.matrix = new UsualMatrix(size, size);
    }

    public void loadFromTextFile(String filename) throws IOException {
        try(var buf = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = buf.readLine()) != null) {
                var split = line.split(" ");
                for (int j = 0; j < this.size; j++)
                    this.matrix.setElement(i, j, Integer.parseInt(split[j]));
                i++;
            }
        }
    }

    public void saveToTextFile(String filename) throws IOException {
        try (var buf = new BufferedWriter(new FileWriter(filename))) {
            buf.write(this.matrix.toString());
        }
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        try (var buf = new BufferedInputStream(new FileInputStream(filename));
             var dis = new DataInputStream(buf)) {
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++)
                    this.matrix.setElement(i, j, dis.readInt());
        }
    }

    public void saveToBinaryFile(String filename) throws IOException {
        try (var buf = new BufferedOutputStream(new FileOutputStream(filename));
             var dos = new DataOutputStream(buf)){
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++)
                    dos.writeInt(this.matrix.getElement(i, j));
        }
    }

    public String toString(){
        return this.matrix.toString();
    }

    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Graph that = (Graph) obj;

        if (this.size != that.size)
            return false;

        return this.matrix.equals(that.matrix);
    }

    public int hashCode() {
        final int prime = 47;
        int result = this.matrix.hashCode();
        result = 31 * result + 19* size;
        return result;
    }
}
