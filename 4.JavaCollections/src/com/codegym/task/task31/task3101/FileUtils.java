package com.codegym.task.task31.task3101;

import java.io.File;

public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Cannot delete file " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Cannot rename file " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }
}