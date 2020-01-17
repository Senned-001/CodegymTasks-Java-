package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.command.CommandExecutor;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.Locale;

public class CashMachine {

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.ENGLISH);

            Operation operation;
            do{
                operation = ConsoleHelper.requestOperation();
                CommandExecutor.execute(operation);
            }while (!operation.equals(Operation.EXIT));
        } catch (InterruptedOperationException e) {
            ConsoleHelper.writeMessage("Good bye!");
        }
    }
}
