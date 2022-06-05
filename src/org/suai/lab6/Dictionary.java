package org.suai.lab6;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> data = new HashMap<String, String>();

    public void setWord(String key, String val){
        data.put(key, val);
    }

    public String getWord(String key){
        return data.get(key);
    }

    public String translate(String s){
        return data.getOrDefault(s, s);
    }

    public String toString(){
        return data.toString();
    }
}
