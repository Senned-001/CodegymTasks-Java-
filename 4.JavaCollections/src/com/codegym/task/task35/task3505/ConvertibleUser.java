package com.codegym.task.task35.task3505;

public class ConvertibleUser implements Convertible<Integer> {
    private Integer id;
    private String name;

    public ConvertibleUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    @Override
    public String toString() {
        return "ConvertibleUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}