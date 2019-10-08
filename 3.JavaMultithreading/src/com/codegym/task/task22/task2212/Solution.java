package com.codegym.task.task22.task2212;

/* 
Phone number verification

*/
public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {
       /* if(phoneNumber.matches("^\\+\\d{12}")) return true;
        if(phoneNumber.matches("(0-9){10}(\\-{1,2}?)")) return true;
        if(phoneNumber.matches("^\\(\\d{3}\\)\\d{7}")) return true;*/
        if(phoneNumber==null) return false;
        return phoneNumber.matches("(^\\+\\d{2})?(\\(\\d{3}\\)\\d{3}\\-?\\d{2}\\-?\\d{2}|\\d{6}\\-?\\d{2}\\-?\\d{2})");
                                        //maybe +11          (111)    111 maybe- 11 maybe- 11 or 111111 maybe- 11 maybe- 11

    }

    public static void main(String[] args) {
        System.out.println(checkPhoneNumber("+17(515)485-8752"));
    }
}
