package com.codegym.task.task29.task2912;

public class SmsLogger extends AbstractLogger implements Logger {

    public SmsLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Send SMS to CEO: " + message);
    }
}