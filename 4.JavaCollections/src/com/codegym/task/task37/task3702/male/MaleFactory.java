package com.codegym.task.task37.task3702.male;

import com.codegym.task.task37.task3702.AbstractFactory;
import com.codegym.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age){
        Human newPerson=null;
        if(age>0&&age<=12) newPerson=new KidBoy();
        if(age>12&&age<=19) newPerson=new TeenBoy();
        if(age>19) newPerson=new Man();
        return newPerson;
    }
}
