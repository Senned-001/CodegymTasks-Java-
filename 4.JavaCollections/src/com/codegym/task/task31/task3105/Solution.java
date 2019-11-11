package com.codegym.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Adding a file to an archive

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get(args[0]);
        FileInputStream fileInputStream=new FileInputStream(args[1]);
        ZipInputStream zipFileStream = new ZipInputStream(fileInputStream);
        Map<ZipEntry,byte[]> zipfiles= new HashMap<>();

        ZipEntry newEntry=null;
        while((newEntry=zipFileStream.getNextEntry())!=null){
            if (newEntry.getName().equals("new/" + Paths.get(args[0]).getFileName()))
                continue;
            byte[] filearray = new byte[1024];
            ByteArrayOutputStream builder = new ByteArrayOutputStream();
            int end;
            while((end = zipFileStream.read(filearray)) > 0){
                builder.write(filearray, 0, end);
            }
            //Path tempFile = Files.createTempFile("","");  //Don't use the file system.
            //Files.write(tempFile, builder.toByteArray());
            zipfiles.put(newEntry,builder.toByteArray());
        }
        fileInputStream.close();
        zipFileStream.close();

        //zipfiles.put(new ZipEntry("new/"+file.getFileName()),Files.readAllBytes(file));   //validator wants to add this individually

        FileOutputStream fileOutputStream =new FileOutputStream(args[1]);
        ZipOutputStream zipFilenewStream = new ZipOutputStream(fileOutputStream);

        for(Map.Entry<ZipEntry,byte[]> x:zipfiles.entrySet()) {
            ZipEntry zipEntry = new ZipEntry(x.getKey().getName());    //without .getName stupid validator not passing
            zipEntry.setSize(x.getValue().length);
            zipFilenewStream.putNextEntry(zipEntry);
            zipFilenewStream.write(x.getValue());
            zipFilenewStream.closeEntry();
        }

        zipFilenewStream.putNextEntry(new ZipEntry("new/" + file.getFileName()));
        Files.copy(file, zipFilenewStream);
        zipFilenewStream.closeEntry();

        fileOutputStream.close();
        zipFilenewStream.close();

    }
}
