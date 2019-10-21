package com.codegym.task.task24.task2405;

public class SecondClass implements Action {   // Second implementation
    public static String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

    private static String SECOND_CLASS_METHOD_STRING = "SecondClass class, someAction method";

    public SecondClass() {
        Solution.actionObjectCount++;
    }
    protected StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

    public void someAction() {
        System.out.println(sb.toString());
    }
}
