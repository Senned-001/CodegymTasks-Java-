package com.codegym.task.task31.task3110;

import com.codegym.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathOfZip=null;
        String pathOffile=null;
        System.out.println("Enter the path of zipfile: ");
        try {
            pathOfZip=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ZipFileManager zipFileManager=new ZipFileManager(Paths.get(pathOfZip));
        System.out.println("Enter the path of file for archive: ");
        try {
            pathOffile=reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            zipFileManager.createZip(Paths.get(pathOffile));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            new ExitCommand().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
