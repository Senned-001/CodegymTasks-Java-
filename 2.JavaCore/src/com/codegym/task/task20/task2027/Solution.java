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

        List<Word> r=detectAllWords(wordSearch, "home", "same", "red");

        for (Word x: r) {
            System.out.println(x.toString());
        }

        /*
Expected result
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {
        List<Word> result=new ArrayList<>();

        int startX=0,startY=0, endX=0, endY=0;
        boolean findedwrite=false;
        for (String slovo : words) {
            for (int i=0;i<wordSearch.length;i++){
                    for(int j=0;j<wordSearch[0].length;j++){
                        if(slovo.charAt(0)==wordSearch[i][j]){  //search to start position
                            startX=j;startY=i;

                            //search
                            while(!findedwrite){

                                //search ->
                                for(int d=1;d<slovo.length();d++) {
                                    if((j+d)<wordSearch[0].length) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i][j + d]) {
                                            endX = j + d;
                                            endY = i;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }

                                //search <-
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if((j-d)>=0) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i][j - d]) {
                                            endX = j - d;
                                            endY = i;
                                            if(d==slovo.length()-1) findedwrite=true;

                                        } else break;
                                    }
                                    else break;
                                }

                                //search up
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if((i-d)>=0) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i - d][j]) {
                                            endX = j;
                                            endY = i - d;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }

                                //search down
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if((i+d)<wordSearch.length) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i + d][j]) {
                                            endX = j;
                                            endY = i + d;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }

                                //search -> and up
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if(((j+d)<wordSearch[0].length)&&((i-d)>=0)) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i - d][j+d]) {
                                            endX = j+d;
                                            endY = i-d;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }

                                //search <- and up
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if(((j-d)>=0)&&((i-d)>=0)) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i - d][j-d]) {
                                            endX = j-d;
                                            endY = i-d;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }

                                //search <- and down
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if(((j-d)>=0)&&((i+d)<wordSearch.length)) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i + d][j-d]) {
                                            endX = j-d;
                                            endY = i+d;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }

                                //search -> and down
                                if(!findedwrite)
                                for(int d=1;d<slovo.length();d++) {
                                    if(((j+d)<wordSearch[0].length)&&((i+d)<wordSearch.length)) {      //check for out of array
                                        if (slovo.charAt(d) == wordSearch[i + d][j+d]) {
                                            endX = j+d;
                                            endY = i+d;
                                            if(d==slovo.length()-1) findedwrite=true;
                                        } else break;
                                    }
                                    else break;
                                }
                                break;
                            }

                        }
                        if(findedwrite) break;
                    }
                    if(findedwrite) break;
            }

            if(findedwrite) {       //if success then add results
                result.add(new Word(slovo));
                result.get(result.size()-1).setStartPoint(startX,startY);
                result.get(result.size()-1).setEndPoint(endX,endY);
            }

            //restore variables for new word
            startX=0;
            startY=0;
            endX=0;
            endY=0;
            findedwrite=false;
        }

        return result;
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
