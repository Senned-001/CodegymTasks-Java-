package com.codegym.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Yet another adapter

*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner=fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] data = fileScanner.nextLine().split(" ");
            DateFormat df = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH);
            return new Person(data[2],data[0],data[1],df.parse(data[3]+data[4]+data[5]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
