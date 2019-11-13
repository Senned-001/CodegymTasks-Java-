package com.codegym.task.task31.task3110;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
        try (
                ZipOutputStream zipOutputStream=new ZipOutputStream(Files.newOutputStream(zipFile));
                InputStream inputStream=Files.newInputStream(source)){

            ZipEntry newFileToZip = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(newFileToZip);

                while ((inputStream.available()>0)){
                    zipOutputStream.write(inputStream.read());
                }
                zipOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
