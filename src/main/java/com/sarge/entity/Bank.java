package com.sarge.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public List<BankAccount> getAllAccounts() {
        return accounts;
    }

    public List<BankAccount> getAllAccountsOfEmployee(Employee employee) {
        List<BankAccount> response = new ArrayList<>();
        for (BankAccount account : accounts) {
            if (account.getEmployee().equals(employee)) {
                response.add(account);
            }
        }
        return response;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }

    public void printAccounts(List<BankAccount> accounts) {
        System.out.printf("%s%n", "╔═══════════════════════════════════════════════════════════════╗");
        System.out.printf("%s%n", "║                        LISTA DE CUENTAS                       ║");
        System.out.printf("%s%n", "╠═══════════════╦═══════════════╦═══════════════╦═══════════════╣");
        System.out.printf("║%-15s║%-15s║%-15s║%-15s║%n", " NÚMERO", " DUEÑO", " TIPO", " GENERO");
        System.out.printf("%s%n", "╚═══════════════╩═══════════════╩═══════════════╩═══════════════╝");
        if (accounts.size() == 0)
            System.out.println("     No hay cuentas registradas");
        for (BankAccount account : accounts) {
            System.out.printf(" %-15s %-15s %-15s %-15s %n", account.getAccountNumber(), account.getEmployee().getName(), account.getType(), account.getBalance());
        }
    }
}
