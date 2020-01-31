package com.codegym.task.task18.task1812;

import java.io.*;

/* 
Extending AmigoOutputStream

*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream n;


    public QuestionFileOutputStream(AmigoOutputStream s) {
        n = s;
    }

    @Override
    public void flush() throws IOException {
        n.flush();
    }

    @Override
    public void write(int b) throws IOException {
        n.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        n.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        n.write(b, off, len);
    }


    @Override
    public void close() throws IOException {
        System.out.println("Do you really want to close the stream? Y/N");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        reader.close();
        if (answer.equals("Y"))
            n.close();
    }
}

