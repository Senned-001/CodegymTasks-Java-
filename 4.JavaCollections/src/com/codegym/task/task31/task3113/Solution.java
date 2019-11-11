package com.codegym.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
What's in the folder?

*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Path path= Paths.get(reader.readLine());
        reader.close();
        if(!Files.isDirectory(path)) {
            System.out.println(path+" is not a folder");
        }
        else{
            SearchFileVisitor searchFileVisitor=new SearchFileVisitor();
            Files.walkFileTree(path, searchFileVisitor);
            System.out.println("Total folders: "+searchFileVisitor.getFolders());
            System.out.println("Total files: "+searchFileVisitor.getFiles());
            System.out.println("Total size: "+searchFileVisitor.getBytes());

        }
    }

    public static class SearchFileVisitor extends SimpleFileVisitor<Path> {
        private int folders=-1; //because it counts root too
        private int files=0;
        private long bytes=0;

        public int getFolders() {
            return folders;
        }

        public int getFiles() {
            return files;
        }

        public long getBytes() {
            return bytes;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(!Files.isDirectory(file)) {
                files++;
                bytes+=Files.size(file);
            }
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            folders++;
            return super.preVisitDirectory(dir, attrs);
        }
    }

}
