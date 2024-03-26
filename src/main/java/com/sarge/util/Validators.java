package com.sarge.util;

import com.sarge.enums.AccountType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validators {

    public static int readIntFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();
        }
        value = scanner.nextInt();
        return value;
    }


    public static String readStringFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String value;
        value = scanner.nextLine();
        return value;
    }

    public static AccountType readAccountTypeFromKeyboard() {
        int accountType;
        do {
            accountType = readIntFromKeyboard();
            if (accountType < 0 || accountType >= AccountType.values().length) {
                System.out.println("Entrada inválida. Por favor, selecciona un número entre 1 y " + (AccountType.values().length - 1) + ".");
            }
        } while (accountType < 0 || accountType >= AccountType.values().length);
        return AccountType.values()[accountType];
    }

    public static String readGenderFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String gender;
        do {
            System.out.print("Género (M/F): ");
            gender = scanner.nextLine();
        } while (!isValidGender(gender));
        return gender;
    }

    private static boolean isValidGender(String gender) {
        return gender.trim().equalsIgnoreCase("M") || gender.trim().equalsIgnoreCase("F");
    }

    public static double readDoubleFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        double value = 0.0;

        do {
            try {
                value = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                scanner.nextLine();
            }
        } while (!validInput);
        return value;
    }}
