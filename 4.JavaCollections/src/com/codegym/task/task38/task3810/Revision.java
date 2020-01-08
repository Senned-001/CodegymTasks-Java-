package com.codegym.task.task38.task3810;

public @interface Revision {
    // Write your own code
    int revision();
    Date date();
    Author[] authors()  default {};
    String comment() default "";
}