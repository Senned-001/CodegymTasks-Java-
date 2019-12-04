package com.codegym.task.task33.task3301;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/* 
My first serialization into JSON

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Missy";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jefferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        convertToJSON(writer, pets);
        System.out.println(writer.toString());
        //[{"name":"Missy","age":5,"weight":3},{"name":"Killer","age":8,"owner":"Bill Jefferson"}]
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }
    @JsonAutoDetect
    public static class Pet {
        String name;
        Pet(){

        }
    }
    @JsonAutoDetect
    public static class Cat extends Pet {
        int age;
        int weight;
        Cat(){

        }
    }
    @JsonAutoDetect
    public static class Dog extends Pet {
        int age;
        String owner;
        Dog(){

        }
    }
}