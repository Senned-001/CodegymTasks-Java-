package com.codegym.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null object pattern

*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path file = Paths.get(pathToFile);
            boolean hidden = Files.isHidden(file);
            boolean executable = Files.isExecutable(file);
            boolean directory=Files.isDirectory(file);
            boolean writable=Files.isWritable(file);
            this.fileData=new ConcreteFileData(hidden,executable,directory,writable);
        } catch (IOException e) {
            this.fileData=new NullFileData(e);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
