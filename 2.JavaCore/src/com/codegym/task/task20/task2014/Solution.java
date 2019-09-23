package com.codegym.task.task20.task2014;

import java.beans.Transient;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution

*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream is=new FileInputStream(args[0]);
        FileOutputStream os=new FileOutputStream(args[0]);
        Solution savedObject = new Solution(5);


        ObjectOutputStream outputStream = new ObjectOutputStream(os);
        outputStream.writeObject(savedObject);
        outputStream.close();
        os.close();



        ObjectInputStream objectStream = new ObjectInputStream(is);
        Solution loadedObject = (Solution) objectStream.readObject();
        objectStream.close();
        is.close();

        System.out.println(savedObject.toString());
        System.out.println(loadedObject.toString());

        //System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
     String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
