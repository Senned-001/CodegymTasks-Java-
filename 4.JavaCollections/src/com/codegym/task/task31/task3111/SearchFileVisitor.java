package com.codegym.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize=0;
    private int maxSize=0;
    private List<Path> foundFiles=new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //byte[] content = Files.readAllBytes(file); // File size: content.length
        //it needs to understand if any parameter is not set (first condition) it seems so all condition of this parameter must true - for this ||
        if ((partOfName==null || file.getFileName().toString().contains(partOfName))&&
        (minSize==0 || attrs.size() > minSize)&&
        (maxSize==0 || attrs.size() < maxSize)&&
        (partOfContent==null || new String(Files.readAllBytes(file)).contains(partOfContent))) foundFiles.add(file);

        //return FileVisitResult.CONTINUE;
       return super.visitFile(file, attrs);
    }
}
