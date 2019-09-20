package com.codegym.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Vowels and consonants

*/

public class Solution {
    public static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        ArrayList<Character> vow = new ArrayList<>();
        ArrayList<Character> con = new ArrayList<>();

        for(int i=0;i<name1.length();i++){
            if(name1.charAt(i)!=' '){
            if(isVowel(name1.charAt(i)))
                vow.add(name1.charAt(i));
            else con.add(name1.charAt(i));}
        }

        for (Character x: vow) {
            System.out.print(x+" ");
        }
        System.out.println();
        for (Character x: con) {
            System.out.print(x+" ");
        }
    }



    // The method checks whether a letter is a vowel
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // Convert to lowercase

        for (char d : vowels)   // Look for vowels in the array
        {
            if (c == d)
                return true;
        }
        return false;
    }
}