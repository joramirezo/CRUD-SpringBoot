package com.semillero.apitienda.persistence.repository;

import com.semillero.apitienda.persistence.entity.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Producto pro SET pro.nombre = :nombre, pro.precio = :precio, pro.cantidad = :cantidad WHERE pro.idProducto = :id")
    void modificarTodoProducto(@Param("id") Long id, @Param("nombre") String nombre, @Param("precio") BigDecimal precio, @Param("cantidad") String cantidad);

    @Modifying
    @Transactional
    @Query("UPDATE Producto pro SET pro.cantidad = :cantidad WHERE pro.idProducto = :id")
    void modificarCantidadProducto(@Param("id") Long id, @Param("cantidad") String cantidad);

}
