package com.codegym.task.task24.task2408;

import java.util.LinkedList;
import java.util.List;

public class Util {
    // Util works well with all Dog and Mouse objects.
    public static void printDialog(List<CanSpeak> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).speak());
        }
    }

    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Dog("Barbossa"));
        pets.add(new Dog("Puppy"));
        pets.add(new Dog("Rover"));
        pets.add(new Mouse());
        pets.add(new Dog("Spot"));
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
