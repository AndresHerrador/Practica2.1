package com.herrador.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordCounter extends Thread {
    private final Path _file;

    public WordCounter(Path file) {
        _file = file;
    }

    @Override
    public void run() {

        try (InputStream in = Files.newInputStream(_file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String ignored : words) {
                    count++;
                }
            }
            System.out.println("File " + _file.getFileName() + " has " + count + " words.\n");


        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }
}
