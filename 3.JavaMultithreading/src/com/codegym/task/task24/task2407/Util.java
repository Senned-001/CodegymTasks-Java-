package com.codegym.task.task24.task2407;

import java.util.LinkedList;
import java.util.List;

public class Util {
    // Util works well with all Cat and Mouse objects. But Mouse does differ from Cat.
    public static void printDialog(List<CanSpeak> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).speak());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Smokey"));
        pets.add(new Cat("Oscar"));
        pets.add(new Cat("Kitty"));
        pets.add(new Mouse());
        pets.add(new Cat("Tom"));
        return pets;
    }

    public static List<CanSpeak> convertPetToCanSpeak(List<Pet> pets) {
        List<CanSpeak> result = new LinkedList<>();
        for (Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toCanSpeak(i));
        }
        return result;
    }
}
