package com.codegym.task.task39.task3908;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Is a palindrome possible?

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("saabS"));
    }

    public static boolean isPalindromePermutation(String s) {
        Set<Character> letters=new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            letters.add(s.toLowerCase().charAt(i));
        }

        Map<Character,Integer>map=new HashMap<>();
        for(Character ch:letters){
            for (int i = 0; i < s.length(); i++) {
                if(s.toLowerCase().charAt(i)==ch) {
                    if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
                    else map.put(ch,1);
                }
            }
        }
        int countOfOdd = 0;
        for(Map.Entry<Character,Integer> x:map.entrySet()){
            if(x.getValue()%2!=0){      //map must have all even numbers of character or possible one odd
                countOfOdd++;
                if(countOfOdd>1)return false;
            }
        }
        return true;
    }
}
