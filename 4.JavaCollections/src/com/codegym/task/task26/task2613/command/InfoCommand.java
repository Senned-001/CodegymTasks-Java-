package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import java.util.Collection;

class InfoCommand implements Command {

    @Override
    public void execute() {
        Collection<CurrencyManipulator> allManipulators=CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean haveMoney = false;
        for(CurrencyManipulator cm:allManipulators){
            if(cm.hasMoney()){
                ConsoleHelper.writeMessage(cm.getCurrencyCode()+" - "+cm.getTotalAmount());
                haveMoney = true;
            }
        }
        if(!haveMoney) ConsoleHelper.writeMessage("No money available.");
    }
}
