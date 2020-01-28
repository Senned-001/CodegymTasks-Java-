package com.codegym.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Number of letters

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Alphabet
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter : abcArray) {
            alphabet.add(letter);
        }
        // Read in strings
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<alphabet.size();i++) {
            map.put(alphabet.get(i), 0);
        }
        for(int i=0;i<list.size();i++) {
            for (int j = 0; j <list.get(i).length(); j++){
                if(alphabet.contains(list.get(i).charAt(j)))
                    map.put(list.get(i).charAt(j),map.get(list.get(i).charAt(j))+1);
            }
        }
        for(HashMap.Entry<Character, Integer>x:map.entrySet()){
            System.out.println(x.getKey()+" "+x.getValue());
        }
        reader.close();
    }
}
