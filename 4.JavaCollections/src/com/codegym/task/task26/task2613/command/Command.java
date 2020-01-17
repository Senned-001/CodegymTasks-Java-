package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

interface Command {

    void execute() throws InterruptedOperationException ;
}
