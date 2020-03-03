package com.codegym.task.task31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
File downloader

*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://codegym.cc/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // Implement this method
        URL url = new URL(urlString);
        String name =urlString.substring( urlString.lastIndexOf('/')+1, urlString.length() );
        String suffix=name.substring(name.lastIndexOf("."),name.length());
        String filename=name.substring(0,name.lastIndexOf("."));
        Path tempFile = Files.createTempFile(filename,suffix);
        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        return Files.move(tempFile,downloadDirectory.resolve(name), StandardCopyOption.REPLACE_EXISTING);
    }
}
