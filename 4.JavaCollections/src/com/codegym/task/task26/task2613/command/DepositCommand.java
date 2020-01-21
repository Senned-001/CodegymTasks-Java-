package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH  + "deposit_en");

    @Override
    public void execute() throws InterruptedOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator currencyManipulator1 = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.requestCurrencyCode());
        String[] s;
        while(true) {
            try {
                s = ConsoleHelper.getTwoValidNumbers(currencyManipulator1.getCurrencyCode());
                currencyManipulator1.addAmount(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
                break;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),Integer.parseInt(s[0]),s[1]));
    }
}
