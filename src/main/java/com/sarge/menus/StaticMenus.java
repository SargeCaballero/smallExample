package com.sarge.menus;

public class StaticMenus {

    private static final String PICK_OPTION = "     Elije una opción: ";

    private StaticMenus() {
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println();
        System.out.println("           MENU PRINCIPAL");
        System.out.println("          ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("     1. Menú de empleados");
        System.out.println("     2. Menú de cuentas");
        System.out.println("     3. Salir");
        System.out.println();
        System.out.print(PICK_OPTION);
    }

    public static void printEmployeeMenu() {
        System.out.println();
        System.out.println();
        System.out.println("           MENU DE EMPLEADO");
        System.out.println("          ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("     1. Crear empleado");
        System.out.println("     2. Seleccionar empleado");
        System.out.println("     3. Listar cuentas de empleado seleccionado");
        System.out.println("     4. Crear cuenta para empleado seleccionado");
        System.out.println("     5. Depositar en cuenta de empleado seleccionado");
        System.out.println("     6. Retirar de cuenta de empleado seleccionado");
        System.out.println("     7. Regresar al menú anterior");
        System.out.println();
        System.out.print(PICK_OPTION);
    }

    public static void printAccountMenu() {
        System.out.println();
        System.out.println();
        System.out.println("           MENU DE CUENTAS");
        System.out.println("          ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("     1. Listar todas las cuentas");
        System.out.println("     3. Eliminar cuenta");
        System.out.println("     4. Regresar al menú anterior");
        System.out.println();
        System.out.print(PICK_OPTION);
    }
}
