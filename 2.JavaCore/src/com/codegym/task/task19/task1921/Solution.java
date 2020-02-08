package com.codegym.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
John Johnson

*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader read1f = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat  df = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
        String name="",date="";
        String data ="";
        while((data=read1f.readLine())!=null){
            String[] d=data.split(" ");
            /*for(int i=0;i<d.length-3;i++){
                name=name+d[i]+" ";
            }*/
            name = data.replaceAll("[0-9]","").trim();
            //name=name.substring(0,name.length()-1);
            date=d[d.length-3]+" "+d[d.length-2]+" "+d[d.length-1];
            PEOPLE.add(new Person(name,df.parse(date)));
        }
        read1f.close();
    }
}
