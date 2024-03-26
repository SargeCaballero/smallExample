package com.sarge.entity;

import com.sarge.entity.Employee;
import com.sarge.enums.AccountType;

public class BankAccount {

    private long accountNumber;
    private Employee employee;
    private double balance = 0;
    private AccountType type;

    public BankAccount(Employee employee, long accountNumber, AccountType type) {
        this.employee = employee;
        this.accountNumber = accountNumber;
        this.type = type;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
