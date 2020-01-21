package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH  + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH  + "login_en");

    @Override
    public void execute() throws InterruptedOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String numberOfCardOfUser;
        String pinCodeOfUser;
        while(true){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
                numberOfCardOfUser = ConsoleHelper.readString();
                pinCodeOfUser = ConsoleHelper.readString();

            if(!validCreditCards.containsKey(numberOfCardOfUser)||!validCreditCards.getString(numberOfCardOfUser).equals(pinCodeOfUser)) {
                ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            ConsoleHelper.writeMessage(res.getString("success.format"));
            break;
        }
    }
}
