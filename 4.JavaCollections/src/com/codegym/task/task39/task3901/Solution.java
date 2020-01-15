package com.codegym.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Unique substrings

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();
        bufferedReader.close();
        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s==null||s.isEmpty()) return 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        int count=0;
        String temp="";
        for(int i=0;i<s.length();i++){
            if(!temp.contains(s.charAt(i)+"")) {
                temp=temp+s.charAt(i);
                count++;
            }
            else {
                temp=s.charAt(i)+"";
                numbers.add(count);
                count=1;
            }
            if(i==s.length()-1){
                numbers.add(count);
            }
        }
        return Collections.max(numbers);
    }
}
