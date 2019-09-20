package com.codegym.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Animal set

*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        for(int i =0;i<4;i++)
            result.add(new Cat());

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> resultd = new HashSet<Dog>();
        for(int i =0;i<3;i++)
            resultd.add(new Dog());
        return resultd;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> pets = new HashSet<>();
        pets.addAll(cats);
        pets.addAll(dogs);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        for(Object x:pets)
            System.out.println(x);
    }

    public static class Cat{

    }

    public static class Dog{

    }
}
