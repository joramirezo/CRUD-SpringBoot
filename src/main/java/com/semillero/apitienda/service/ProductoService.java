package com.semillero.apitienda.service;

import com.semillero.apitienda.exceptions.ApiTiendaExceptions;
import com.semillero.apitienda.persistence.entity.Producto;
import com.semillero.apitienda.persistence.repository.ProductoRepository;
import com.semillero.apitienda.service.dto.ProductoDTO;
import com.semillero.apitienda.service.mapper.ProductoDTOToProducto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository repository;
    private final ProductoDTOToProducto mapper;

    public Producto agregarProducto(ProductoDTO productoDTO){
       Producto producto = mapper.map(productoDTO);
        return this.repository.save(producto);
    }

    public List<Producto> findAll(){
        return this.repository.findAll();
    }

    public void modificarTodoProducto(Long idProducto, String nombre, BigDecimal precio, String cantidad) {
        Optional<Producto> optionalProducto = this.repository.findById(idProducto);
        if(optionalProducto.isEmpty()){
            throw new ApiTiendaExceptions("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.modificarTodoProducto(idProducto, nombre, precio, cantidad);
    }

    public void modificarCantidadProducto(Long idProducto, String cantidad){
        Optional<Producto> optionalProducto = this.repository.findById(idProducto);
        if(optionalProducto.isEmpty()){
            throw new ApiTiendaExceptions("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.modificarCantidadProducto(idProducto, cantidad);
    }

    public void eliminarProducto(Long idProducto){
        Optional<Producto> optionalProducto = this.repository.findById(idProducto);
        if(optionalProducto.isEmpty()){
            throw new ApiTiendaExceptions("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(idProducto);
    }

    public ProductoService(ProductoRepository repository, ProductoDTOToProducto mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
