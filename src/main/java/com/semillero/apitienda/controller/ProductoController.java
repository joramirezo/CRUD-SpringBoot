package com.semillero.apitienda.controller;

import com.semillero.apitienda.persistence.entity.Producto;
import com.semillero.apitienda.persistence.repository.ProductoRepository;
import com.semillero.apitienda.service.ProductoService;
import com.semillero.apitienda.service.dto.ProductoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductoController {
    private final ProductoService productoService;

    @Tag(name = "Agregar producto", description = "Permite agregar un producto al carrito de compras")
    @PostMapping("/agregarProductos")
    public Producto agregarProducto(@RequestBody ProductoDTO productoDTO){
        return this.productoService.agregarProducto(productoDTO);
    }

    @Tag(name = "Mostrar todos los productos", description = "Permite mostrar todos los productos del carrito de compras")
    @GetMapping("/mostrarTodosLosProductos")
    public List<Producto> mostrarTodosProductos(){
        return this.productoService.findAll();
    }
    @Tag(name = "Modificar todos los atributos de un producto", description = "Permite modificar todos los atributos de un producto a excepción del id")
    @PutMapping("/modificarProductos/{id}")
    public void modificarTodoProducto(@PathVariable Long id, @RequestParam String nombre, @RequestParam BigDecimal precio, @RequestParam String cantidad) {
        productoService.modificarTodoProducto(id, nombre, precio, cantidad);
    }
    @Tag(name = "Modificar la cantidad de un producto", description = "Permite modificar la cantidad de un producto")
    @PutMapping("/modificarCantidadProductos/{id}")
    public void modificarCantidadProducto(@RequestParam Long id, @RequestParam String nuevaCantidad){
        productoService.modificarCantidadProducto(id, nuevaCantidad);
    }
    @Tag(name = "Eliminar producto", description = "Permite eliminar un producto")
    @DeleteMapping("/eliminarProductos/{id}")
    public void eliminarProducto(@PathVariable("id") Long id){
        this.productoService.eliminarProducto(id);
    }

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

}
