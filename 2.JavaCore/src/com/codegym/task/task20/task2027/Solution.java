package com.codegym.task.task20.task2027;

import java.util.*;

/* 
Word search

*/
public class Solution {
    public static void main(String[] args) {
        int[][] wordSearch = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(wordSearch, "home", "same");
        /*
Expected result
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {
        List<Word> result=new ArrayList<>();



        for (String slovo : words) {
            for(int s=0;s<slovo.length();s++){
                for (int i=0;i<wordSearch.length;i++){
                    for(int j=0;j<wordSearch[0].length;j++){
                        if(slovo.charAt(s)==wordSearch[i][j]){
                            result.add(new Word(slovo));
                            result.get(result.size()-1).setStartPoint(i,j);
                        }
                    }
                }
            }




        }



        return null;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
