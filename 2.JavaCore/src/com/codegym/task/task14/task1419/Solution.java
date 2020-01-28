package com.codegym.task.task14.task1419;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* 
Exception invasion

*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   // The first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] m=new int[2];
            m[3]=2;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            List<Integer> l = new LinkedList<>();
            l.get(2);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] m=new int[-2];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int c = Integer.parseInt("s");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object o = null;
            o.toString();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileOutputStream f = new FileOutputStream("C:/output.file");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String st = "sas";
            char cg = st.charAt(4);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            a aaa = new a();
            b bbb = (b)aaa;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //write your code here
        try {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

    public static void dou (byte s){
    }

    public static class a {}

    public static class b extends a{}
}
