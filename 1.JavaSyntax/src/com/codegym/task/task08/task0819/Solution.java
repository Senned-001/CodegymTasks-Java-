package com.codegym.task.task08.task0819;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set of cats

*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        for (Cat s:cats){
        cats.remove(s);break;}

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<Cat>();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat s:cats)
            System.out.println(s);
    }

    public static class Cat {

    }
}
