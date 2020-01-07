package com.codegym.task.task38.task3809;

public class CodeGymBankAccount {
    private String ownerName;

    @LongPositive
    private long amount;

    public CodeGymBankAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}