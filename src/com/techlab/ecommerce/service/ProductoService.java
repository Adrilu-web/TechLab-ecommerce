package com.techlab.ecommerce.service;

import com.techlab.ecommerce.exception.ProductoNoEncontradoException;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.util.Validador;

import java.util.ArrayList;
import java.util.List;

// Lógica de negocio de los productos
public class ProductoService {

    // Lista que actúa como "base de datos" en memoria
    private List<Producto> productos = new ArrayList<>();

    // Genera  ID único 
    private static int contadorId = 1;

    // Guarda un producto nuevo después de validar sus datos
    public Producto guardar(Producto p) {
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());
        Validador.validarRubro(p.getRubro());

        p.setId(contadorId++);   // Asigna ID único
        productos.add(p);        // Lo agrega a la lista
        return p;
    }

    // Devuelve todos los productos cargados
    public List<Producto> listarTodos() {
        return productos;
    }

    // Busca un producto por ID; si no existe, lanza excepción
    public Producto obtenerPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No se encontró un producto con id " + id);
    }

    // Actualiza un producto existente reemplazando todos sus campos
    public Producto actualizar(int id, Producto datos) {
        Producto p = obtenerPorId(id); // Busca el producto original

        // Valida los nuevos datos
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());
        Validador.validarRubro(datos.getRubro());

        // Aplica los cambios
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());
        p.setRubro(datos.getRubro());

        return p;
    }

    // Elimina un producto por ID
    public void eliminar(int id) {
        Producto p = obtenerPorId(id); // Si no existe, lanza excepción
        productos.remove(p);
    }
}
