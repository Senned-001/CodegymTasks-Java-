package com.codegym.task.task38.task3809;

/* 
Annotation + reflection

*/

public class Solution {
    public static void main(String[] args) throws IllegalAccessException {
        CodeGymBankAccount account = new CodeGymBankAccount("Mr.Smith");
        System.out.println("Check No. 1:");
        ReflectionAnnotationUtil.check(account);

        System.out.println("Check No. 2:");
        account.setAmount(100);
        ReflectionAnnotationUtil.check(account);

        System.out.println("Check No. 3:");
        ReflectionAnnotationUtil.check(new IncorrectAccount());
/* Expected output:

Check No. 1:
The amount field in the CodeGymBankAccount class has a LongPositive annotation, but its value is not positive.
Check No. 2:
Check No. 3:
The amountString field in the IncorrectAccount class has a LongPositive annotation, but its type is String.

*/
    }
}