package com.codegym.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {

        try {
            this.path= Files.createTempFile("temp-",".tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {

        }
    }

    public long getFileSize(){              //Returns the size of the file pointed to by path.
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0L;
        }
    }

    public void putEntry(Entry entry){      //Serializes the passed entry to the file.

        try (ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(path))){
            while (entry != null) {
                oos.writeObject(entry);
                entry = entry.next;
            }
        } catch (IOException e) {

        }

    }

    public Entry getEntry(){                //Gets an entry from the file. If the file size is zero, return null.
        Entry ent=null;
        if(getFileSize()==0L) return ent;
        try (ObjectInputStream ois=new ObjectInputStream(Files.newInputStream(path))){
            ent=(Entry)ois.readObject();

        } catch (Exception e) {

        }
        return ent;
    }

    public void remove() {                  //Delete the file pointed to by path.
        try {
            Files.delete(path);
        } catch (IOException e) {

        }
    }
}
