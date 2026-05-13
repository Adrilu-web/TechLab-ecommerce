package com.techlab.ecommerce.ui;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.util.Validador;

import java.util.Scanner;

public class MenuProducto {

    private final Scanner sc;
    private final ProductoService service;

    // Recibe dependencias desde Main
    public MenuProducto(Scanner sc, ProductoService service) {
        this.sc = sc;
        this.service = service;
    }

    // Bucle principal del menú
    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = Validador.leerEntero(sc, "Elija una opción: ");

            try {
                switch (opcion) {
                    case 1 -> agregarProducto();      // Alta
                    case 2 -> listarProductos();      // Listado
                    case 3 -> buscarProducto();       // Búsqueda por ID
                    case 4 -> actualizarProducto();   // Modificación
                    case 5 -> eliminarProducto();     // Baja
                    case 6 -> System.out.println("¡Hasta luego!");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                // Muestra cualquier error de validación o negocio
                System.out.println("⚠ " + e.getMessage());
            }

            System.out.println();

        } while (opcion != 6);
    }

    // Muestra el menú principal
    public void mostrarMenu() {
        System.out.println("\n--- TechLab --- Gestión de Productos ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
    }

    // Alta de producto (todos los campos obligatorios)
    public void agregarProducto() {
        System.out.println("\n--- Nuevo producto ---");

        String nombre = Validador.leerTextoObligatorio(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTextoObligatorio(sc, "Categoría: ");
        String rubro = Validador.leerTextoObligatorio(sc, "Rubro: ");

        Producto guardado = service.guardar(
                new Producto(nombre, precio, stock, categoria, rubro)
        );

        System.out.println("✔ Producto agregado con id " + guardado.getId());
        System.out.println("Datos del producto: " + guardado);
    }

    // Lista todos los productos
    public void listarProductos() {
        System.out.println("\n--- Lista de productos ---");

        if (service.listarTodos().isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        for (Producto p : service.listarTodos()) {
            System.out.println(p);
        }
    }

    // Busca un producto por ID
    public void buscarProducto() {
        System.out.println("\n--- Buscar producto ---");
        int id = Validador.leerEntero(sc, "ID: ");
        Producto p = service.obtenerPorId(id);
        System.out.println("Encontrado: " + p);
    }

    // Actualiza un producto (Enter conserva valores)
    public void actualizarProducto() {
        System.out.println("\n--- Actualizar producto ---");

        int id = Validador.leerEntero(sc, "ID del producto: ");
        Producto actual = service.obtenerPorId(id);

        System.out.println("Datos actuales: " + actual);
        System.out.println("Ingrese nuevos valores (Enter para mantener los actuales)");

        // Nombre (texto libre)
        String nombre = Validador.leerTexto(sc, "Nombre (" + actual.getNombre() + "): ");
        if (!nombre.trim().isEmpty()) {
            Validador.validarNombre(nombre);
            actual.setNombre(nombre);
        }

        // Precio (usa leerDouble si el usuario escribe algo)
        String precioStr = Validador.leerTexto(sc, "Precio (" + actual.getPrecio() + "): ");
        if (!precioStr.trim().isEmpty()) {
            double precio = Validador.leerDouble(sc, "Nuevo precio: ");
            actual.setPrecio(precio);
        }

        // Stock (usa leerEntero si el usuario escribe algo)
        String stockStr = Validador.leerTexto(sc, "Stock (" + actual.getStock() + "): ");
        if (!stockStr.trim().isEmpty()) {
            int stock = Validador.leerEntero(sc, "Nuevo stock: ");
            actual.setStock(stock);
        }

        // Categoría
        String categoria = Validador.leerTexto(sc, "Categoría (" + actual.getCategoria() + "): ");
        if (!categoria.trim().isEmpty()) {
            Validador.validarCategoria(categoria);
            actual.setCategoria(categoria);
        }

        // Rubro
        String rubro = Validador.leerTexto(sc, "Rubro (" + actual.getRubro() + "): ");
        if (!rubro.trim().isEmpty()) {
            Validador.validarRubro(rubro);
            actual.setRubro(rubro);
        }

        System.out.println("✔ Producto actualizado correctamente.");
    }
    // Elimina un producto por ID
    public void eliminarProducto() {
        System.out.println("\n--- Eliminar producto ---");
        int id = Validador.leerEntero(sc, "ID: ");
        service.eliminar(id);
        System.out.println("✔ Producto eliminado.");
    }
}
