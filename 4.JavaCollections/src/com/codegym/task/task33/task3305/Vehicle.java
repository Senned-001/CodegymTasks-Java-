package com.codegym.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="className")        ////CLASS-full Classname as property
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}