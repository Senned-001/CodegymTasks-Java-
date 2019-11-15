package com.codegym.task.task28.task2801;

/* 
Mastering switch

*/
public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* Output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        // Add your code here
        switch(obj.getClass().getSimpleName()){
            case "E1":{
                System.out.println("it's E1."+obj.toString());break;
            }

            case "E2":{
                System.out.println("it's E2."+obj.toString());break;
            }

            default:  System.out.println("undefined");
        }

    }
}
