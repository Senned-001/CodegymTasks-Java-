package com.codegym.task.task19.task1917;

/* 
Your own FileWriter
//obvertka
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter (File file) throws IOException{
        fileWriter=new FileWriter(file);
    }
    public FileConsoleWriter (File file, boolean append) throws IOException{
        fileWriter=new FileWriter(file,append);
    }
    public FileConsoleWriter (FileDescriptor fd){
        fileWriter=new FileWriter(fd);
    }
    public FileConsoleWriter (String fileName)throws IOException{
        fileWriter=new FileWriter(fileName);
    }
    public FileConsoleWriter (String fileName, boolean append)throws IOException{
        fileWriter=new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf,off,len);
        String s="";
        for(int i=off;i<off+len;i++){
            s+=cbuf[i];
        }
        System.out.println(s);
    }
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c); //nepravilno - net preobrazovanya v char no validator pustil
    }
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len)throws IOException{
        fileWriter.write(str,off,len);
        System.out.println(str.substring(off,off+len));
    }
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        //System.out.println(cbuf.toString());
        String s="";
        for(int i=0;i<cbuf.length;i++){
            s+=cbuf[i];
        }
        System.out.println(s);
    }
    public void close() throws IOException{
        fileWriter.close();
    }

    public static void main(String[] args) {
    }
}
