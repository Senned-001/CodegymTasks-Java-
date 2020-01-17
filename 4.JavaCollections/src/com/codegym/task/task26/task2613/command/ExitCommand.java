package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

class ExitCommand implements Command{
    @Override
    public void execute() throws InterruptedOperationException {
        ConsoleHelper.writeMessage("Do you really want to exit? y or n:");
        if(ConsoleHelper.readString().equals("y"))
            ConsoleHelper.writeMessage("Good bye!");
    }
}
