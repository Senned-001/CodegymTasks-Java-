package com.codegym.task.task35.task3502;

import java.util.List;

/*
Introducing generics

*/
public class Solution<T extends List<Solution.SomeClass>> {
    public static class SomeClass<T extends Number> {
    }

    public static void main(String[] args) {

    }
}
