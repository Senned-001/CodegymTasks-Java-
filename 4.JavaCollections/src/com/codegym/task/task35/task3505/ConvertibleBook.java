package com.codegym.task.task35.task3505;

public class ConvertibleBook implements Convertible<String> {
    private String name;

    public ConvertibleBook(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public String toString() {
        return "ConvertibleBook{" +
                "name='" + name + '\'' +
                '}';
    }
}