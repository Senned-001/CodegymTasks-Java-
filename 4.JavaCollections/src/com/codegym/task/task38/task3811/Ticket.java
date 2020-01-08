package com.codegym.task.task38.task3811;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Ticket {
    enum Priority {LOW, MEDIUM, HIGH}
    Priority priority() default Priority.MEDIUM;
    String[] tags() default {};
    String createdBy() default "Amigo";
}
