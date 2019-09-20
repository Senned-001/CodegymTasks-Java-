package com.codegym.task.task07.task0707;

import java.sql.SQLOutput;
import java.util.ArrayList;

/* 
What sort of list is that?

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String s="sss";
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<5;i++){
            s=s+i;
            list.add(s);}
        System.out.println(list.size());
        for(int i=0;i<5;i++)
            System.out.println(list.get(i));
    }
}
