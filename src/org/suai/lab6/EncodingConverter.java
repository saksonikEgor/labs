package org.suai.lab6;

import java.io.*;

public class EncodingConverter {
    public void convert(String inputFile, String outputFile, String firstEncoding, String secondEncoding) throws IOException {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), firstEncoding));
             BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), secondEncoding))){
            String s;
            while((s = bufReader.readLine()) != null){
                bufWriter.write(s);
                bufWriter.flush();
            }
        }
    }
}