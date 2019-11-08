package com.codegym.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Find all the files

*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String>files=new ArrayList<>();
        Queue<File> subcatalogs=new PriorityQueue<>();
        File startpath = new File(root);
        for(File x:startpath.listFiles()){
            if(x.isDirectory()) {
                if(x.listFiles().length!=0) subcatalogs.add(x);
            }
            else files.add(x.getAbsolutePath());
        }
        if (!subcatalogs.isEmpty()){
            while(!subcatalogs.isEmpty()) {
                File p = subcatalogs.poll();
                for (File x : p.listFiles()) {
                    if (x.isDirectory()) {
                        if (x.listFiles().length != 0) subcatalogs.add(x);
                    } else files.add(x.getAbsolutePath());
                }
            }
        }

        return files;

    }

    public static void main(String[] args) {

    }
}