package com.semillero.apitienda.service.mapper;

import com.semillero.apitienda.persistence.entity.Producto;
import com.semillero.apitienda.service.dto.ProductoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoDTOToProducto implements IMapper<ProductoDTO, Producto>{
    @Override
    public Producto map(ProductoDTO in) {
        Producto producto = new Producto();
        producto.setNombre(in.getNombre());
        producto.setPrecio(in.getPrecio());
        producto.setCantidad(in.getCantidad());
        return producto;
    }
}
