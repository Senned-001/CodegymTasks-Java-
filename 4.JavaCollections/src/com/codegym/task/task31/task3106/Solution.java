package com.codegym.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Unzipping a file

*/
public class Solution {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream(args[0]);
        args[0] = "";
        Arrays.sort(args);
        ArrayList<FileInputStream> parts = new ArrayList<>();

        for(int i=1;i<args.length;i++) {
            parts.add(new FileInputStream(args[i]));
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(parts));
        ZipInputStream zipFileStream = new ZipInputStream(sequenceInputStream);
        zipFileStream.getNextEntry();
        byte[] filearray = new byte[1024];
        ByteArrayOutputStream builder = new ByteArrayOutputStream();
        int end;
        while ((end = zipFileStream.read(filearray)) > 0) {
            builder.write(filearray, 0, end);
        }
        out.write(builder.toByteArray());
        out.flush();

        zipFileStream.close();
        sequenceInputStream.close();
        out.close();
    }
}
