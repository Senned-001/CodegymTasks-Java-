package com.codegym.task.task24.task2407;

import java.util.List;

/* 
Implementing an interface using a local class

*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<CanSpeak> pets = Util.convertPetToCanSpeak(pet);
        Util.printDialog(pets);
    }
}
