package com.codegym.task.task17.task1721;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        String name1="";
        String name2="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            name1 = reader.readLine();
            name2= reader.readLine();
            reader.close();



            BufferedReader reader1 = new BufferedReader(new FileReader(name1));

            String line = reader1.readLine();
            while (line != null){
                allLines.add(line);
                line = reader1.readLine();
            }
             reader1.close();


            BufferedReader reader2 = new BufferedReader(new FileReader(name2));

            String line2 = reader2.readLine();
            while (line2 != null){
                linesForRemoval.add(line2);
                line2 = reader2.readLine();
            }
            reader2.close();

        Solution s=new Solution();
        s.joinData();

    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(linesForRemoval)) allLines.removeAll(linesForRemoval);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }



    }
}
