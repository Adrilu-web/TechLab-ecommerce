package com.techlab.ecommerce.util;

import com.techlab.ecommerce.exception.StockInsuficienteException;
import java.util.Scanner;

public class Validador {


    // Validaciones de negocio
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
    }

    public static void validarRubro(String rubro) {
        if (rubro == null || rubro.trim().isEmpty()) {
            throw new IllegalArgumentException("El rubro no puede estar vacío.");
        }
    }


    // Lectura con validación
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Debe ingresar un número entero. No puede quedar vacío.");
                continue;
            }

            try {
                int valor = Integer.parseInt(input);

                if (valor < 0) {
                    System.out.println("El stock no puede ser negativo.");
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Debe ingresar un número. No puede quedar vacío.");
                continue;
            }

            try {
                double valor = Double.parseDouble(input);

                if (valor <= 0) {
                    System.out.println("El precio debe ser mayor a 0.");
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    // Permite vacío (para actualizar)
    public static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    // NO permite vacío (para agregar)
    public static String leerTextoObligatorio(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Debe ingresar un texto. No puede quedar vacío.");
        }
    }
}
