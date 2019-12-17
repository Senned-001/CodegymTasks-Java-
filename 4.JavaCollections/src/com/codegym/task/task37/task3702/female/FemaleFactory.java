package com.codegym.task.task37.task3702.female;

import com.codegym.task.task37.task3702.AbstractFactory;
import com.codegym.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        Human newPerson=null;
        if(age>0&&age<=12) newPerson=new KidGirl();
        if(age>12&&age<=19) newPerson=new TeenGirl();
        if(age>19) newPerson=new Woman();
        return newPerson;
    }
}
