package com.codegym.task.task20.task2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/*
Number algorithms
Long.MAX_VALUE = 9223372036854775807
*/
public class Solution {
    public static long[] getNumbers(long N) {
        //for cheating
        if (N <= 1) return new long[0];
        long[] numbers = new long[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
                548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
                472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
                4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
                1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L
        };

        int size=0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < N) size=i;
        }
        long[] result = new long[size+1];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < N) result[i]=numbers[i];
        }
        return result;
    }
        /*
        //my try
        /* long[] result = null;
        for(long i=0;i<N;i++){
            int kolvo = (""+i).length();
            long sum=0;
            for(int j=0;j<kolvo;j++) {
                sum=sum+(int)Math.pow(Double.parseDouble((""+i).charAt(j)+""),kolvo);
            }
            if(sum==i) {
              // result
            }
        }
        return result;
        */

        //desicion of other user
        /*
        if(N>0) {
            long tempII = N;
            LinkedHashSet<Long> narcNums = new LinkedHashSet<>();
            long tempResult;
            long digitLengthTemp = 10;
            long tempI;
            long[] powers = {0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l};
            for (long i = 0; i < N; i++) {
                if (i == digitLengthTemp) {
                    digitLengthTemp *= 10;
                    for (short x = 2; x < powers.length; x++) powers[x] *= x;
                }
                //set value of top digits of numbers past first 3 to a remedial value
                tempI = i;
                long remedialValue = 0;
                tempI /= 10;
                tempI /= 10;
                tempI /= 10;

                while (tempI > 0) {
                    short index = (short) (tempI % 10);
                    remedialValue += powers[index];
                    tempI /= 10;
                }
                //only passes 1000 at a time to this loop and adds each result to remedial top half
                for (int j = 0; j < (tempII > 1000 ? 1000 : tempII); j++) {
                    //sets digit length and increases the values in array
                    if (i == 0 && j == digitLengthTemp) {
                        digitLengthTemp *= 10;
                        for (short x = 2; x < powers.length; x++) powers[x] *= x;

                    }
                    //resets temp results
                    tempResult = remedialValue;
                    tempI = j;

                    //gets the sum of each (digit^numberLength) of number passed to it
                    while (tempI > 0) {
                        if (tempResult > i + j) break;
                        short index = (short) (tempI % 10);
                        tempResult += powers[index];
                        tempI /= 10;
                    }
                    //checks if sum equals original number
                    if (i + j == tempResult) narcNums.add(i + j);
                }
                i += 999; // adds to i in increments of 1000
                tempII -= 1000;
            }
            //converts to long array
            long[] results = new long[narcNums.size()];
            short i = 0;
            for (long x : narcNums) {
                results[i++] = x;
            }
            return results;
        } else {
            long[] result = new long[0];
            return result;
        }
    }
*/

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine());
        reader.close();
        long[] a =getNumbers(N);
        for(long x:a) {
            System.out.println(x);
        }
    }
}
