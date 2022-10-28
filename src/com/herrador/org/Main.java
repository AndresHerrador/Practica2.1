package com.herrador.org;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {


    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "Files");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file : stream) {
                new WordCounter(file).start();
            }


        }

    }

}