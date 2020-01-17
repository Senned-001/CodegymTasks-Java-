package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptedOperationException{
        String str = null;
        try {
            str = bis.readLine();
            if(str.toUpperCase().equals("EXIT"))
                throw new InterruptedOperationException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String requestCurrencyCode() throws InterruptedOperationException{
        String currencyCode = "";
        while(true) {
            writeMessage("Please enter a currency code:");
            currencyCode = readString();
            if (currencyCode.length() == 3) break;
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getTwoValidNumbers(String currencyCode) throws InterruptedOperationException{
        String[] result = new String[2];
        while(true) {
            writeMessage("Please enter a denomination of banknotes and number of banknotes:");
            String s = readString();
            if (s != null && s.matches("\\d+\\s\\d+")) {
                result = s.split(" ");
                break;
            }
            else writeMessage("Error, numbers are invalids");
        }
        return result;
    }

    public static Operation requestOperation() throws InterruptedOperationException{
        writeMessage("Choose the operation 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT:");
        Operation op = null;
        while(true) {
            try {
                op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (NumberFormatException  e) {
                writeMessage("Wrong operation, repeat");
                continue;
            }
            break;
        }
        return op;
    }
}
