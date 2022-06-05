package org.suai.lab7;

import java.io.*;
import java.util.HashMap;

public class Settings {
    private final HashMap<String,Integer> settingTable = new HashMap<String, Integer>();

    public void put(String s, int val){
        settingTable.put(s, val);
    }

    public int get(String s){
        return settingTable.get(s);
    }

    public void delete(String s){
        settingTable.remove(s);
    }

    public void saveToBinaryFile(String filename) throws IOException {
        try (var buf = new BufferedOutputStream(new FileOutputStream(filename));
             var dos = new DataOutputStream(buf)){
            dos.writeInt(settingTable.size());
            for (var entry : settingTable.entrySet()) {
                dos.writeUTF(entry.getKey());
                dos.writeInt(entry.getValue());
            }
        }
    }

    public void saveToTextFile(String filename) throws IOException {
        try (var buf = new BufferedWriter(new FileWriter(filename))) {
            String curS = String.valueOf(settingTable.size()) + '\n';
            buf.write(curS);
            for (var entry : settingTable.entrySet()) {
                String s = entry.getKey() + " " + entry.getValue() + '\n';
                buf.write(s);
            }
        }
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        try (var buf = new BufferedInputStream(new FileInputStream(filename));
             var dis = new DataInputStream(buf)) {
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                settingTable.put(dis.readUTF(), dis.readInt());
            }
        }
    }

    public void loadFromTextFile(String filename) throws IOException {
        try(var buf = new BufferedReader(new FileReader(filename))) {
            String line;
            buf.readLine();
            while ((line = buf.readLine()) != null) {
                var split = line.split(" ");
                this.put(split[0], Integer.parseInt(split[1]));
            }
        }
    }

    public String toString(){
        return settingTable.toString();
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!( obj instanceof Settings))
            return false;

        Settings a = (Settings) obj;
        return a.settingTable.equals(this.settingTable);
    }
}
