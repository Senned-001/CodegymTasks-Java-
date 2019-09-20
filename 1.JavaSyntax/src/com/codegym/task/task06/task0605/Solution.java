package com.codegym.task.task06.task0605;


import java.io.*;

/* 
Controlling body weight

*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateBMI(weight, height);
    }

    public static class Body {
        public static void calculateBMI(double weight, double height) {
            double bmi = weight/(height*height);
            if (bmi<18.5) System.out.println("Underweight: BMI < 18.5");
                else if ((bmi>=18.5)&&(bmi<=24.9)) System.out.println("Normal: 18.5 <= BMI <= 24.9");
                    else if ((bmi>=25)&&(bmi<=29.9)) System.out.println("Overweight: 25 <= BMI <= 29.9");
                        else if(bmi>=30) System.out.println("Obese: BMI >= 30");
        }
    }
}
