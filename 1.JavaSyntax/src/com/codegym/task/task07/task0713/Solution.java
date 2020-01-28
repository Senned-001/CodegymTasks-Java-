package com.codegym.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Playing Javarella

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i=0;i<20;i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        for(int i=0;i<20;i++){
            if (list.get(i)%3==0)
                list3.add(list.get(i));
            if (list.get(i)%2==0)
                list2.add(list.get(i));
            if ((list.get(i)%2!=0)&&(list.get(i)%3!=0))
                list1.add(list.get(i));
        }
        printList(list3);
        printList(list2);
        printList(list1);
        reader.close();
    }


    public static void printList(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}
