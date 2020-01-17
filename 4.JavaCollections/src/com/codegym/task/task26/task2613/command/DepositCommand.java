package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

class DepositCommand implements Command{

    @Override
    public void execute() throws InterruptedOperationException {
        CurrencyManipulator currencyManipulator1 = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.requestCurrencyCode());
        String[] s=ConsoleHelper.getTwoValidNumbers(currencyManipulator1.getCurrencyCode());
        currencyManipulator1.addAmount(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
    }
}
