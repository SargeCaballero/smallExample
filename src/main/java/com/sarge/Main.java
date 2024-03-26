package com.sarge;

import com.sarge.entity.Bank;
import com.sarge.entity.BankAccount;
import com.sarge.entity.Employee;
import com.sarge.enums.AccountType;
import com.sarge.fakedata.Generator;

import java.util.*;

import static com.sarge.menus.StaticMenus.*;
import static com.sarge.util.Validators.*;

public class Main {

    private static Employee createEmployee() {
        System.out.println();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del empleado: ");
        String name = scanner.nextLine();
        System.out.print("Apellido: ");
        String surname = scanner.nextLine();
        System.out.print("Género (M/F): ");
        String gender = readGenderFromKeyboard();
        System.out.print("Edad: ");
        int age = readIntFromKeyboard();
        return new Employee.EmployeeBuilder(name, surname).gender(gender).age(age).build();
    }

    private static Employee searchForEmployeeByName(List<Employee> universe, String name, String surname) {
        for (Employee employee : universe) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname.trim())) {
                return employee;
            }
        }
        return null;
    }

    private static void printEmployees(List<Employee> employees) {
        System.out.printf("%s%n","╔═══════════════════════════════════════════════════════════════╗");
        System.out.printf("%s%n","║                      LISTA DE EMPLEADOS                       ║");
        System.out.printf("%s%n","╠═══════════════╦═══════════════╦═══════════════╦═══════════════╣");
        System.out.printf("║%-15s║%-15s║%-15s║%-15s║%n"," NOMBRE"," APELLIDO", " EDAD", " GENERO");
        System.out.printf("%s%n","╚═══════════════╩═══════════════╩═══════════════╩═══════════════╝");
        for (Employee employee : employees) {
            System.out.printf(" %-15s %-15s %-15s %-15s %n",employee.getName(),employee.getSurname(), employee.getAge(), employee.getGender());
        }
    }

    private static void printSelectedEmployee(Employee employee) {
        if (employee != null) {
            System.out.printf("%s%n", "╔═══════════════════════════════════════════════════════════════╗");
            System.out.printf("║  Empleado seleccionado: %10s %10s                 ║%n", employee.getName().toUpperCase(), employee.getSurname().toUpperCase());
            System.out.printf("%s%n", "╚═══════════════════════════════════════════════════════════════╝");
        }
    }

    private static BankAccount createAccount(Employee employee) {
        System.out.println();
        System.out.println();
        System.out.print("Ingresa el número de cuenta: ");
        int accountNumber = readIntFromKeyboard();
        System.out.println("Selecciona el tipo de cuenta:");
        AccountType accountType;
        for (AccountType type : AccountType.values()) {
            System.out.println(type.ordinal() + ". " + type.name());
        }
        accountType = readAccountTypeFromKeyboard();
        return new BankAccount(employee, accountNumber, accountType);
    }

    private static boolean validateDeposit(BankAccount account, double amount) {
        return account.getBalance() + amount <= account.getType().getMaxAmount();
    }

    private static boolean validateWithdrawal(BankAccount account, double amount) {
        return account.getBalance() - amount >= account.getType().getMinAmount();
    }

    private static BankAccount searchBankAccountByNumber(Bank bank, long accountNumber) {
        for (BankAccount account : bank.getAllAccounts()) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int option;
        int suboption;
        Bank bank = new Bank();
        Employee selectedEmployee = null;
        List<Employee> employees = new ArrayList<>();

        employees.add(Generator.generateEmployee());
        employees.add(Generator.generateEmployee());
        employees.add(Generator.generateEmployee());

        do {
            printEmployees(employees);
            printMainMenu();
            option = readIntFromKeyboard();
            switch (option) {
                case 1:
                    do {
                        printEmployees(employees);
                        printSelectedEmployee(selectedEmployee);
                        printEmployeeMenu();
                        suboption = readIntFromKeyboard();
                        String accountNumber;
                        BankAccount account;
                        double amount;
                        switch (suboption) {
                            case 1: // Crear empleado
                                employees.add(createEmployee());
                                break;
                            case 2: // Seleccionar empleado
                                System.out.print("Escribe el nombre y apellido del empleado separado por espacios: ");
                                String fullname = readStringFromKeyboard();
                                String[] words = fullname.trim().split(" ");
                                selectedEmployee = searchForEmployeeByName(employees, words[0], fullname.substring(words[0].length()));
                                if (selectedEmployee == null) {
                                    System.out.println("El empleado no existe.");
                                }
                                break;
                            case 3: // Listar cuentas de empleado seleccionado
                                List<BankAccount> accounts = bank.getAllAccountsOfEmployee(selectedEmployee);
                                bank.printAccounts(accounts);
                                break;
                            case 4: // Crear cuenta para empleado seleccionado
                                createAccount(selectedEmployee);
                                break;
                            case 5: // Depositar en cuenta de empleado seleccionado
                                do {
                                    System.out.print("Número de cuenta (0 para cancelar): ");
                                    accountNumber = readStringFromKeyboard();
                                    account = searchBankAccountByNumber(bank, Long.parseLong(accountNumber));
                                    if (account == null) {
                                        System.out.println("La cuenta no existe.");
                                    }
                                } while (account == null && !accountNumber.equals("0"));
                                System.out.print("Cantidad a depositar: ");
                                amount = readDoubleFromKeyboard();
                                if (validateDeposit(account, amount)) {
                                    account.setBalance(account.getBalance() + amount);
                                } else {
                                    System.out.println("La cantidad a depositar excede el límite permitido.");
                                }
                                break;
                            case 6: // Retirar de cuenta de empleado seleccionado
                                do {
                                    System.out.print("Número de cuenta (0 para cancelar): ");
                                    accountNumber = readStringFromKeyboard();
                                    account = searchBankAccountByNumber(bank, Long.parseLong(accountNumber));
                                    if (account == null) {
                                        System.out.println("La cuenta no existe.");
                                    }
                                } while (account == null && !accountNumber.equals("0"));
                                System.out.print("Cantidad a depositar: ");
                                amount = readDoubleFromKeyboard();
                                if (validateWithdrawal(account, amount)) {
                                    account.setBalance(account.getBalance() + amount);
                                } else {
                                    System.out.println("La cantidad a depositar excede el límite permitido.");
                                }
                                break;
                            case 7: // Regresar al menú anterior
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                        }
                    } while (suboption != 5);
                    break;
                case 2:
                    printAccountMenu();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
            }
        } while (option != 3);
    }
}