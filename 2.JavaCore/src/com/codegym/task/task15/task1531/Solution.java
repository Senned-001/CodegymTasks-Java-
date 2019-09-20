package com.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Factorial

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if(n <0) return "0";
        else if(n==0) return "1";
            else if(n<=150) {
            BigInteger fac = BigInteger.valueOf(1);     //obyavlenie i ustanovka celochislennogo bolshogo
                for (int i=1;i<=n;i++)
                    fac=fac.multiply(BigInteger.valueOf(i));//umnogenie
                return ""+fac;
            }
        else return "";
    }
}
