package com.codegym.task.task35.task3510;

import java.util.ArrayList;
import java.util.List;

/* 
Entry prohibited!

*/
public class House<T> {

    private List<T> residents = new ArrayList<>();

    public void admit(T resident) {
        residents.add(resident);
        //checkConflicts();
    }

    public <T> void expel(T resident) {
        residents.remove(resident);
    }

    /*private void checkConflicts() {
        boolean conflict = false;
        for (Object resident : residents) {
            if (resident instanceof Dog) {
                conflict = true;
            }
        }

        if (conflict) {
            Iterator iterator = residents.iterator();
            while (iterator.hasNext()) {
                Object resident = iterator.next();
                if (resident instanceof Cat) {
                    iterator.remove();
                }
            }
        }
    }*/

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("The house has the following residents:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy cooper = new Puppy("Cooper");
        Cat smudge = new Cat("Smudge");
        Kitten molly = new Kitten("Molly");

        House<Dog> dogHouse = new House();
        dogHouse.admit(bruno);
        dogHouse.admit(cooper);
        //dogHouse.admit(smudge);
        System.out.println(dogHouse.toString());

        House<Cat> catHouse = new House();
        catHouse.admit(smudge);
        catHouse.admit(molly);
        //catHouse.admit(bruno);
        System.out.println(catHouse.toString());
    }
}