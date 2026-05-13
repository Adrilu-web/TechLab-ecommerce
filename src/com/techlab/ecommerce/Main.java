package com.techlab.ecommerce;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.ui.MenuProducto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Dependencias principales
        Scanner sc = new Scanner(System.in);
        ProductoService service = new ProductoService();

        // Carga inicial opcional
        cargarDatosDePrueba(service);

        // Inicia el menú principal
        MenuProducto menu = new MenuProducto(sc, service);
        menu.iniciar();

        sc.close();
    }

    // Carga productos para probar el sistema
    private static void cargarDatosDePrueba(ProductoService service) {

        service.guardar(new Producto("Agua mineral 2L", 1200, 80, "Bebidas", "Almacén y bebidas"));
        service.guardar(new Producto("Jugo de naranja 1L", 1800, 40, "Bebidas", "Almacén y bebidas"));
        service.guardar(new Producto("Coca-Cola 1.5L", 2100, 60, "Bebidas", "Almacén y bebidas"));
        service.guardar(new Producto("Té en saquitos x25", 950, 35, "Bebidas", "Almacén y bebidas"));

        service.guardar(new Producto("Arroz largo fino 1kg", 1300, 100, "Almacén", "Almacén y bebidas"));
        service.guardar(new Producto("Harina 000 1kg", 900, 120, "Almacén", "Almacén y bebidas"));
        service.guardar(new Producto("Fideos spaghetti 500g", 1100, 90, "Almacén", "Almacén y bebidas"));
        service.guardar(new Producto("Azúcar 1kg", 950, 70, "Almacén", "Almacén y bebidas"));
        service.guardar(new Producto("Sal fina 500g", 450, 150, "Almacén", "Almacén y bebidas"));

        service.guardar(new Producto("Alfajor triple chocolate", 750, 50, "Golosinas", "Golosinas y snacks"));
        service.guardar(new Producto("Caramelos surtidos 500g", 1300, 40, "Golosinas", "Golosinas y snacks"));
        service.guardar(new Producto("Gomitas frutales 200g", 900, 60, "Golosinas", "Golosinas y snacks"));
        service.guardar(new Producto("Barra de cereal chocolate", 650, 80, "Golosinas", "Golosinas y snacks"));

        service.guardar(new Producto("Papas fritas clásicas 120g", 1500, 45, "Snacks", "Golosinas y snacks"));
        service.guardar(new Producto("Maní salado 200g", 1100, 70, "Snacks", "Golosinas y snacks"));
        service.guardar(new Producto("Nachos sabor queso 140g", 1700, 30, "Snacks", "Golosinas y snacks"));

        service.guardar(new Producto("Jabón de tocador x3", 1600, 25, "Higiene", "Higiene y limpieza"));
        service.guardar(new Producto("Shampoo 400ml", 3200, 20, "Higiene", "Higiene y limpieza"));
        service.guardar(new Producto("Pasta dental 90g", 1100, 40, "Higiene", "Higiene y limpieza"));

        service.guardar(new Producto("Lavandina 1L", 900, 50, "Limpieza", "Higiene y limpieza"));
        service.guardar(new Producto("Detergente 750ml", 1200, 35, "Limpieza", "Higiene y limpieza"));
        service.guardar(new Producto("Esponjas x3", 700, 60, "Limpieza", "Higiene y limpieza"));

        service.guardar(new Producto("Atún en aceite 170g", 1800, 25, "Enlatados", "Enlatados y conservas"));
        service.guardar(new Producto("Arvejas 300g", 750, 40, "Enlatados", "Enlatados y conservas"));
        service.guardar(new Producto("Tomates triturados 520g", 950, 55, "Enlatados", "Enlatados y conservas"));

        service.guardar(new Producto("Leche entera 1L", 1300, 80, "Lácteos", "Lácteos y frescos"));
        service.guardar(new Producto("Yogur firme frutilla 190g", 700, 50, "Lácteos", "Lácteos y frescos"));
        service.guardar(new Producto("Queso cremoso 1kg", 4500, 20, "Lácteos", "Lácteos y frescos"));

        service.guardar(new Producto("Pimienta negra molida 50g", 900, 30, "Condimentos", "Especias y condimentos"));
        service.guardar(new Producto("Orégano 25g", 600, 40, "Condimentos", "Especias y condimentos"));
        service.guardar(new Producto("Pimentón dulce 50g", 850, 35, "Condimentos", "Especias y condimentos"));
    }
}