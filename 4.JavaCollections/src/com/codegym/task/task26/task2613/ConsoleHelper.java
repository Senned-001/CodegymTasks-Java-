package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptedOperationException{
        String str = null;
        try {
            str = bis.readLine();
            if(str.toUpperCase().equals(res.getString("operation.EXIT"))) {
                writeMessage(res.getString("the.end"));
                throw new InterruptedOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String requestCurrencyCode() throws InterruptedOperationException{
        String currencyCode = "";
        while(true) {
            writeMessage(res.getString("choose.currency.code"));
            currencyCode = readString();
            if (currencyCode.length() == 3) break;
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getTwoValidNumbers(String currencyCode) throws InterruptedOperationException{
        String[] result = new String[2];
        while(true) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            String s = readString();
            if (s != null && s.matches("\\d+\\s\\d+")) {
                result = s.split(" ");
                break;
            }
            else writeMessage(res.getString("invalid.data"));
        }
        return result;
    }

    public static Operation requestOperation() throws InterruptedOperationException{
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.INFO"));
        writeMessage(res.getString("operation.DEPOSIT"));
        writeMessage(res.getString("operation.WITHDRAW"));
        Operation op = null;
        while(true) {
            try {
                op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (NumberFormatException  e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }

        return op;
    }

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
