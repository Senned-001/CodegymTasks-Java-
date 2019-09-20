package com.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;



/* 
User, loser, coder and programmer

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        // Here's the loop for reading the keys. Item 1
        while (true) {
            key = reader.readLine();
            if (key.equals("user")) {person = new Person.User();doWork(person);}
            else if (key.equals("loser")) {person = new Person.Loser();doWork(person);}
            else if (key.equals("coder")) {person = new Person.Coder();doWork(person);}
            else if (key.equals("programmer")) {person = new Person.Programmer();doWork(person);}
            else break;
        }


            // Create an object. Item 2

             // Call doWork


    }

    public static void doWork(Person person) {
        // Item 3
        if(person instanceof Person.User) ((Person.User)person).live();
        if(person instanceof Person.Loser) ((Person.Loser)person).doNothing();
        if(person instanceof Person.Coder) ((Person.Coder)person).writeCode();
        if(person instanceof Person.Programmer) ((Person.Programmer)person).enjoy();
    }
}
