package com.codegym.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getExeption (Enum message){
        if(message!=null) {
            String mes = message.toString().substring(0, 1) + message.toString().substring(1).toLowerCase();
            mes = mes.replaceAll("_", " ");
            if (message instanceof ApplicationExceptionMessage) return new Exception(mes);
            if (message instanceof DatabaseExceptionMessage) return new RuntimeException(mes);
            if (message instanceof UserExceptionMessage) return new Error(mes);
        }
            return new IllegalArgumentException();
    }
}
