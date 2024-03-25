package com.dh.Xplorando.service;

import com.dh.Xplorando.dto.entrada.ProductoEntradaDto;
import com.dh.Xplorando.dto.entrada.modificacion.ProductoModificacionEntrada;
import com.dh.Xplorando.dto.salida.ProductoSalidaDto;
import com.dh.Xplorando.entity.Producto;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<ProductoSalidaDto> listarProductos();
    ProductoSalidaDto crearProducto(ProductoEntradaDto producto) throws BadRequestException, ResourceNotFoundException;

    ProductoSalidaDto editarProducto(ProductoModificacionEntrada productoModificacionEntrada) throws ResourceNotFoundException;

    void eliminarProductoPorId(Long id) throws ResourceNotFoundException;
    ProductoSalidaDto buscarProductoPorId(Long id)throws ResourceNotFoundException;
    Optional<Producto> buscarProductoXId(Long id);
    //buscar producto por su ubicacion
    Optional<List<Producto>> listarProductoXUbicacion(Long id) throws ResourceNotFoundException;

    //buscar producto por su ubicacion junto a las dos fechas que yo le pase
    Optional <List<Producto>> listarProductosXUbicacionFechas(Long id , LocalDate fechaInicio, LocalDate fechaFinal);

}