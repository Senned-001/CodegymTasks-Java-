package com.codegym.task.task38.task3810;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Changelog {
    // Write your own code
    Revision[] value();
}