package com.codegym.task.task18.task1813;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream

*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream obj;

    public AmigoOutputStream (FileOutputStream l) throws FileNotFoundException{
       super(fileName);
        obj=l;
    }

    public AmigoOutputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    @Override
    public void flush() throws IOException {
        obj.flush();
    }

    @Override
    public void write(int b) throws IOException {
        obj.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        obj.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        obj.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        obj.flush();
        String s="CodeGym © All rights reserved.";
        obj.write(s.getBytes());
        obj.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
