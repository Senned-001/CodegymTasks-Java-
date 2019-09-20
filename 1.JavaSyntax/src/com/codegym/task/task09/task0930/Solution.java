package com.codegym.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Task about algorithms

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        ArrayList<Integer> chisl = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
            if (isNumber(array[i]))
                chisl.add(Integer.parseInt(array[i]));
            else
                str.add(array[i]);

      /*  System.out.println("chisl ");
        for (Integer x : chisl) {
            System.out.println(x);}

        System.out.println("str ");
        for (String x : str) {
            System.out.println(x);}


        /*for (int i = 0; i < chisl.size(); i++)
            for (int j = 0; j < chisl.size() - 1; j++) {
                if (!isGreaterThan(chisl.get(j), chisl.get(j + 1))) {
                    Integer l = chisl.get(j);
                    chisl.set(j, chisl.get(j + 1));
                    chisl.set(j + 1, l);
                }
            }*/
        Collections.sort(chisl);
        Collections.reverse(chisl);
      /*  System.out.println("chisl otsort");
        for (Integer x : chisl) {
            System.out.println(x);}*/

        for (int i = 0; i < str.size(); i++)
            for (int j = 0; j < str.size() - 1; j++) {
                if (isGreaterThan(str.get(j), str.get(j + 1))) {
                    String l = str.get(j);
                    str.set(j, str.get(j + 1));
                    str.set(j + 1, l);

                }
            }
       /* System.out.println("str otsort");
        for (String x : str) {
            System.out.println(x);}
*/
        int indchisl=0,indstr=0;

        for (int i = 0; i < array.length; i++)
            if (isNumber(array[i])){
                array[i]=String.valueOf(chisl.get(indchisl));indchisl++;
            }
            else{
                array[i]=str.get(indstr);indstr++;
            }



    }

    // String comparison method: 'a' is greater than 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Is the passed string a number?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // The string contains a hyphen
                    || (!Character.isDigit(c) && c != '-') // or is not a number and doesn't start with a hyphen
                    || (i == 0 && c == '-' && chars.length == 1)) // or is a single hyphen
            {
                return false;
            }
        }
        return true;
    }
}
