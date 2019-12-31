package com.codegym.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));

        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Pete Tyson",null, null));
        System.out.println(logParser.getIPsForStatus(Status.ERROR,null, null));
        System.out.println(logParser.getIPsForEvent(Event.COMPLETE_TASK,null, null));


    }
}