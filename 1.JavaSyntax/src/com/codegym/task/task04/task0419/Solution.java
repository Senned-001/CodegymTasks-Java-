package com.codegym.task.task04.task0419;

/* 
Maximum of four numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m[];
        m = new int[4];

        m[0] = Integer.parseInt(reader.readLine());
        m[1] = Integer.parseInt(reader.readLine());
        m[2] = Integer.parseInt(reader.readLine());
        m[3] = Integer.parseInt(reader.readLine());
        int max=0,max1=0;
       // for (int i=0;i<3;i++)
       // {if(m[i]>m[i+1]) max = m[i];
       //         else max = m[i+1];}

        if (m[0]>m[1]) max = m[0];
            else max = m[1];
        if (m[2]>m[3]) max1 = m[2];
            else max1 = m[3];
        if (max1>max) max = max1;

        System.out.println(max);

    }
}
