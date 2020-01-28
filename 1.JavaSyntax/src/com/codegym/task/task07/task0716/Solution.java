package com.codegym.task.task07.task0716;

import java.util.ArrayList;

/* 
R or L

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("rose"); // 0
        list.add("love"); // 1
        list.add("lyre"); // 2
        list = fix(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        int r;
        int l;
        for(int i=0;i<list.size();i++) {
            r=0;l=0;
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == 'l')
                    l++;
                if (list.get(i).charAt(j) == 'r')
                    r++;
            }
            if ((l>0)&&(r==0)) {list.add(i+1,list.get(i));i++;}
                else if ((r>0)&&(l==0)) {
                    list.remove(i);i--;
                }
        }
        return list;
    }
}