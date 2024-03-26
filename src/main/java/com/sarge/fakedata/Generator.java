package com.sarge.fakedata;

import com.sarge.entity.Employee;

import java.util.Random;

public class Generator {

    private static final Random random = new Random();

    private static final String[] apellidosLatinos = {
            "González",
            "Rodríguez",
            "Gómez",
            "Fernández",
            "López",
            "Díaz",
            "Martínez",
            "Pérez",
            "García",
            "Sánchez",
            "Ramírez",
            "Torres",
            "Vásquez",
            "Castillo",
            "Rojas",
            "Mendoza",
            "Hernández",
            "Jiménez",
            "Moreno",
            "Cruz",
            "Álvarez",
            "Romero",
            "Medina",
            "Suárez",
            "Ortiz",
            "Chávez",
            "Silva",
            "Guerrero",
            "Rivera",
            "Flores"
    };

    private static final String[] nombresLatinos = {
            "Juan",
            "María",
            "José",
            "Ana",
            "Carlos",
            "Luis",
            "Laura",
            "Fernando",
            "Gabriela",
            "Ricardo",
            "Sofía",
            "Diego",
            "Valentina",
            "Javier",
            "Isabella",
            "Miguel",
            "Camila",
            "Andrés",
            "Daniela",
            "Alejandro",
            "Adriana",
            "Mateo",
            "Emma",
            "Santiago",
            "Lucía",
            "Daniel",
            "Valeria",
            "Emiliano",
            "Mariana",
            "Victoria"
    };

    public static int obtenerNumeroAleatorio() {
        return random.nextInt(30);
    }

    public static Employee generateEmployee () {
        String apellido = apellidosLatinos[obtenerNumeroAleatorio()];
        String nombre = nombresLatinos[obtenerNumeroAleatorio()];
        int edad = random.nextInt(60) + 18;
        return new Employee.EmployeeBuilder(nombre, apellido).age(edad).gender("M").build();
    }
}
