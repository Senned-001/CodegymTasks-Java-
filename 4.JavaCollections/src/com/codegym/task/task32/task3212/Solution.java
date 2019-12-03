package com.codegym.task.task32.task3212;

import com.codegym.task.task32.task3212.service.Service;

/* 
Service locator

*/

public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

    }

}
