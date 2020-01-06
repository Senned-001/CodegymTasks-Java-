package com.codegym.task.task38.task3801;

/* 
Fix coding errors

*/

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                System.out.println("The name contains " + NameChecker.getNumberOfCharacters(args[0]) + " characters");
            } catch (NameIsNullException e) {
                System.out.println("Error: No name was specified");
            } catch (NameIsEmptyException e) {
                System.out.println("Error: The name is empty");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}