package com.codegym.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //write your code here
        //String date = birthday.substring(0,birthday.lastIndexOf(".")+1)+year;
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate = LocalDate.parse(birthday,dTF);
        LocalDate reqDate = localDate.withYear(Year.parse(year).getValue());
        return reqDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}