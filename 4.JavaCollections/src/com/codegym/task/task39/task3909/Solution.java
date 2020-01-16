package com.codegym.task.task39.task3909;

/* 
One change

*/
public class Solution {
    public static void main(String[] args) {
        String s = "asadsa";
        String t = "asasa";
        System.out.println(isOneEditAway(s,t));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.isEmpty() || second.isEmpty()||first.equals(second)) {
            return true;
        }
        if(Math.abs(first.length()-second.length())>1) return false;

        String max=first.length()>second.length()?"s"+first.toLowerCase()+"s":"s"+second.toLowerCase()+"s";
        String min=max.equals("s"+first.toLowerCase()+"s")?"s"+second.toLowerCase()+"s":"s"+first.toLowerCase()+"s";
        char[] maxMas=max.toCharArray();
        char[] minMas=min.toCharArray();
        for(int i =0;i<minMas.length;i++){
            if(minMas[i]!=maxMas[i]){
                if(minMas.length==maxMas.length){           //if length of strings equal then need replace one char
                    char temp=minMas[i];
                    minMas[i]=maxMas[i];
                    if(max.equals(String.valueOf(minMas))) return true;
                    else {
                        maxMas[i]=temp;
                        if(min.equals(String.valueOf(maxMas))) return true;
                        else return false;
                    }
                }
                else{                                       //if no it needs paste one simbol from max to min
                   if(max.equals(min.substring(0,i)+max.charAt(i)+min.substring(i))){
                       return true;
                   }
                   else return false;
                }
            }
        }
        return false;
    }
}
