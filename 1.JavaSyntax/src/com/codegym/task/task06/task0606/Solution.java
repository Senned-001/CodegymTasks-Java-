package com.codegym.task.task06.task0606;

import java.io.*;

/* 
Even and odd digits

*/

public class Solution {

    //



    public static int even=0;
    public static int odd=0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int dl =str.length();
       // int m[];
       // m = new int[dl];

        for (int i=0;i<dl;i++){
           // m[i] = Character.getNumericValue(str.charAt(i)); //perevod simvola stroki v chislo
           //
            // if (m[i]%2==0) even++;
            if (Character.getNumericValue(str.charAt(i))%2==0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
