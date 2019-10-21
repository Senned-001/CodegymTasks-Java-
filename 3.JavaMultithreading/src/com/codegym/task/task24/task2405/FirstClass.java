package com.codegym.task.task24.task2405;

public abstract class FirstClass implements Action {     // First implementation

    protected FirstClass() {
        Solution.actionObjectCount++;
    }

    public void someAction() {
        System.out.println("FirstClass class, someAction method");
    }

    public abstract Action getDependentAction();
}
