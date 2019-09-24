package com.codegym.task.task20.task2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Number algorithms
Long.MAX_VALUE = 9223372036854775807
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;

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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine());
        reader.close();

        System.out.println(getNumbers(N).toString());

    }
}
