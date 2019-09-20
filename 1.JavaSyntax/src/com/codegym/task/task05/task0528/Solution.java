package com.codegym.task.task05.task0528;
import java.time.LocalDate;

/* 
Display today's date

*/

public class Solution {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.getMonthValue()+" " +today.getDayOfMonth()+ " "+ today.getYear());
    }
}
