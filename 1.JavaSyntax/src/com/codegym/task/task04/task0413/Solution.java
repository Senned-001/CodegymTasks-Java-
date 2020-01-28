package com.codegym.task.task04.task0413;

/* 
Day of the week

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a==1)
            System.out.println("Monday");
        else if (a==2)
            System.out.println("Tuesday");
        else if (a==3)
            System.out.println("Wednesday");
        else if (a==4)
            System.out.println("Thursday");
        else if (a==5)
            System.out.println("Friday");
        else if (a==6)
            System.out.println("Saturday");
        else if (a==7)
            System.out.println("Sunday");
        else System.out.println("No such day of the week");
        reader.close();
    }
}