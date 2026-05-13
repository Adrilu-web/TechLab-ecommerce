package com.techlab.ecommerce.model;

// Definicion de producto dentro del sistema
public class Producto {

    // Atributos del producto
    private int id;             // Identificador único asignado por el sistema
    private String nombre;      // Nombre del producto
    private double precio;      // Precio unitario
    private int stock;          // Cantidad disponible
    private String categoria;   // Categoría general (ej: Bebidas, Almacén)
    private String rubro;       // Rubro específico (ej: Almacén y bebidas)

    // Constructor para crear un producto nuevo
    public Producto(String nombre, double precio, int stock, String categoria, String rubro) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.rubro = rubro;
    }

    // Constructor vacío
    public Producto() {}

    // Acceder y modificar los atributos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }

    // Pasaje a texto para mostrar el producto
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + nombre +
                " | $" + precio +
                " | Stock: " + stock +
                " | Cat: " + categoria +
                " | Rubro: " + rubro;
    }
}

