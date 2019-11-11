package com.codegym.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Your own implementation

*/
public class Solution {
    public static byte[] readBytes(String filename) throws IOException {
        return Files.readAllBytes(Paths.get(filename));
    }

    public static List<String> readLines(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    public static void writeBytes(String filename, byte[] bytes) throws IOException {
        Files.write(Paths.get(filename),bytes);
    }

    public static void copy(String resourceFilename, String destinationFilename) throws IOException {
        Files.copy(Paths.get(resourceFilename),Paths.get(destinationFilename));

    }

}