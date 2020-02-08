package com.codegym.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Replacing numbers

*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        reader.close();

        BufferedReader read1f = new BufferedReader(new FileReader(name1));
        String data = "";
        String result = "";
        while ((data = read1f.readLine()) != null) {
            result = data;
            char punct;
            String[] raz = result.split(" |\\n");//split string on " " and "\n"
            result = "";
            for (int i = 0; i < raz.length; i++) {          //if end of word is sign of punctuation
                if (raz[i].charAt(raz[i].length() - 1) == '.' ||
                        raz[i].charAt(raz[i].length() - 1) == ',' ||
                        raz[i].charAt(raz[i].length() - 1) == '?' ||
                        raz[i].charAt(raz[i].length() - 1) == '!' ||
                        raz[i].charAt(raz[i].length() - 1) == ':' ||
                        raz[i].charAt(raz[i].length() - 1) == ';') {
                    punct = raz[i].charAt(raz[i].length() - 1); //remember him
                    raz[i] = raz[i].substring(0, raz[i].length() - 1);//and delete for parsing to int
                    try {
                        int n = Integer.parseInt(raz[i]);       //try parsing to int
                        if (n >= 0 && n <= 12)                  //if good changing
                            raz[i] = map.get(Integer.parseInt(raz[i])) + punct;
                    } catch (NumberFormatException e) {
                        raz[i] = raz[i] + punct;                //if not good return sign of punct
                    }

                }
                try {
                    int n = Integer.parseInt(raz[i]);       //try to parsing to int if without sign at end of word
                    if (n >= 0 && n <= 12)
                        raz[i] = map.get(Integer.parseInt(raz[i]));
                } catch (NumberFormatException e) {
                }
                result = result + raz[i] + " ";
            }
            result = result.trim();
            result = result + "\n";
            System.out.println(result);
        }
        read1f.close();
    }
}