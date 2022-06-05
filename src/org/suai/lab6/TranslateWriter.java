package org.suai.lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class TranslateWriter extends FileWriter {
    private final Dictionary dictionary;

    public TranslateWriter(String filename, Dictionary dictionary) throws IOException {
        super(filename);
        this.dictionary = dictionary;
    }

    @Override
    public void write(String s) throws IOException {
            var res = translate(s.trim());
            this.write(translate(s.trim()), 0, res.length());
    }

    private String translate(String s) {
        return Arrays.stream(s.split(" "))
            .map(dictionary::translate)
            .filter(Objects::nonNull)
            .collect(Collectors.joining(" "));
    }
}
