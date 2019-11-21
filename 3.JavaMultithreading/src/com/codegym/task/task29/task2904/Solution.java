package com.codegym.task.task29.task2904;

/* 
Autoboxing features

*/
public class Solution {
    private Integer[] intArray = new Integer[]{1, 2, 3, 4};

    public static void main(String[] args) {
        Number value1 = new Solution().getValueByIndex(5); // -1.0, class java.lang.Double expected
        Number value2 = new Solution().getValueByIndex(2); // 3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());
    }

    Number getValueByIndex(int i) {
        return (i >= 0 && i < intArray.length) ? (Number)intArray[i] : (Number)new Double(-1);
    }
}
