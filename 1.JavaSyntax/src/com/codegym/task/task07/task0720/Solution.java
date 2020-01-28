package com.codegym.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Shuffled just in time

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<N;i++) {
            list.add(reader.readLine());
        }
        for(int i=0;i<M;i++) {
            list.add(list.get(i));
        }
        Iterator <String> listiterator = list.iterator(); //iterator for remove
        String s = list.get(M);
        while (!listiterator.next().equals(s)) {
            listiterator.remove();
        }
        for (String x : list) {
            System.out.println(x);
        }
        reader.close();
    }
}
