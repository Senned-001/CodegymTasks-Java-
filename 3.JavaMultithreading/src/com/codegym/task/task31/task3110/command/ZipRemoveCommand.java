package com.codegym.task.task31.task3110.command;

import com.codegym.task.task31.task3110.ConsoleHelper;
import com.codegym.task.task31.task3110.ZipFileManager;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ZipRemoveCommand extends ZipCommand{

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Removal from archive.");
        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Which file to remove:");
        Path pathList=Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(pathList);
        ConsoleHelper.writeMessage("File removed successfully");
    }

}
