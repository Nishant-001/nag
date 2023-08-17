package com.Bank.BankingManagementNew.Exceptions;

public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(String message) {
        super(message);
    }
}