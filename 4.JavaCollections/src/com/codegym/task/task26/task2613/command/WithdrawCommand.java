package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InsufficientFundsException;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.*;

class WithdrawCommand implements Command{
    @Override
    public void execute() throws InterruptedOperationException {
        CurrencyManipulator currencyManipulator1 = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.requestCurrencyCode());
        while(true) {
            ConsoleHelper.writeMessage("Enter a sum of withdraw:");
            int expectedAmount;
            try {
                expectedAmount = Integer.parseInt(ConsoleHelper.readString());
                if(expectedAmount<=0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Sum is not correct");
                continue;
            }
            if(currencyManipulator1.isAmountAvailable(expectedAmount)){
                Map<Integer, Integer> withdrawAmountMap;
                try {
                    withdrawAmountMap = currencyManipulator1.withdrawAmount(expectedAmount);
                } catch (InsufficientFundsException e) {
                    ConsoleHelper.writeMessage("There are insufficient banknotes, please enter other sum");
                    continue;
                }
                Set<Integer> keys = withdrawAmountMap.keySet();
                List<Integer> result = new ArrayList<>(keys);
                Collections.sort(result);
                Collections.reverse(result);
                for(Integer x:result){
                    ConsoleHelper.writeMessage("\t"+x+" - "+withdrawAmountMap.get(x));
                }
                ConsoleHelper.writeMessage("Transaction was successful");
                break;
            }
            else {
                ConsoleHelper.writeMessage("There are not enough money, try other sum");
            }
        }
    }
}
