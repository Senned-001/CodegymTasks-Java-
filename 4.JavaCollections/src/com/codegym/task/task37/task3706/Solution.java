package com.codegym.task.task37.task3706;

import java.util.Arrays;
import java.util.List;

/* 
The long forgotten Array

*/
public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.<Number>asList(1, 2, 3);
        addDataToList(numbers, getData());
        System.out.println(numbers);
    }

    public static Number[] getData() {
        Number[] numbers=new Number[0];
        return numbers;
    }

    public static void addDataToList(List<Number> list, Number... data) {
        for (Number number : data) {
            list.add(number);
        }
    }
}
