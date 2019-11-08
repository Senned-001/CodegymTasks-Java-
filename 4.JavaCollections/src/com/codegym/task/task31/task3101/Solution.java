package com.codegym.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Iterating through a file tree

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        File resultFileAbsolutePath = new File(args[1]);

        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"\\allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath,allFilesContent);

        List<File>result=new ArrayList<>();

        for(File x:getFileTree(path)){
            if(x.length()<=50){
                result.add(x);
            }
        }

        Comparator<File>byfilename=new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        result.sort(byfilename);

        BufferedWriter buff=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(allFilesContent)));

        for(File x:result){
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(x)));
            while (reader.ready()) {
                buff.write(reader.readLine());

            }
            buff.write("\n");
            buff.flush();
            reader.close();
        }
        buff.close();
    }


    public static List<File> getFileTree(String root) throws IOException {
        List<File>files=new ArrayList<>();
        Queue<File> subcatalogs=new PriorityQueue<>();
        File startpath = new File(root);
        for(File x:startpath.listFiles()){
            if(x.isDirectory()) {
                if(x.listFiles().length!=0) subcatalogs.add(x);
            }
            else files.add(x);
        }
        if (!subcatalogs.isEmpty()){
            while(!subcatalogs.isEmpty()) {
                File p = subcatalogs.poll();
                for (File x : p.listFiles()) {
                    if (x.isDirectory()) {
                        if (x.listFiles().length != 0) subcatalogs.add(x);
                    } else files.add(x);
                }
            }
        }
        return files;
    }
}