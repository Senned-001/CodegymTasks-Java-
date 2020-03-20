package com.codegym.task.task36.task3605;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Using TreeSet

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<Character>result=new TreeSet<>();
        FileReader isr=new FileReader(args[0]);
        int symb;
        while((symb=isr.read())!=-1) {
            Character c=Character.toLowerCase((char) symb);
            if(Character.isLetter(c))
                result.add(c);
        }
        isr.close();
        int s=0;
        for(Character r:result){
               if(s==5) break;
               System.out.print(r);
               s++;

        }
    }
}
