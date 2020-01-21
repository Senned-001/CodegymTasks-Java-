package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InsufficientFundsException;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.*;

class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptedOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator currencyManipulator1 = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.requestCurrencyCode());
        while(true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            int expectedAmount;
            try {
                expectedAmount = Integer.parseInt(ConsoleHelper.readString());
                if(expectedAmount<=0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if(currencyManipulator1.isAmountAvailable(expectedAmount)){
                Map<Integer, Integer> withdrawAmountMap;
                try {
                    withdrawAmountMap = currencyManipulator1.withdrawAmount(expectedAmount);
                } catch (InsufficientFundsException e) {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    continue;
                }
                Set<Integer> keys = withdrawAmountMap.keySet();
                List<Integer> result = new ArrayList<>(keys);
                Collections.sort(result);
                Collections.reverse(result);
                for(Integer x:result){
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),x,withdrawAmountMap.get(x)+""));
                }
                break;
            }
            else {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }
    }
}
