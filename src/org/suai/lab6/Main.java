package org.suai.lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String  []args) {
        var d = new Dictionary();
        d.setWord("home", "дом");
        d.setWord("house", "дом");
        d.setWord("cat", "кот");
        d.setWord("street", "улица");
        d.setWord("pharmacy", "аптека");

        try (var wr = new TranslateWriter("/Users/egor/Desktop/output.txt", d)){
            wr.write("my sweet home");
            wr.write('\n');
            wr.write("house street lamp pharmacy");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

