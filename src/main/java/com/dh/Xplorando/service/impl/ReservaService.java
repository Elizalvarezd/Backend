package com.dh.Xplorando.service.impl;

import com.dh.Xplorando.dto.entrada.ReservaEntradaDto;
import com.dh.Xplorando.dto.salida.*;
import com.dh.Xplorando.entity.Producto;
import com.dh.Xplorando.entity.Reserva;
import com.dh.Xplorando.entity.User;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;
import com.dh.Xplorando.repository.ProductoRepository;
import com.dh.Xplorando.repository.ReservaRepository;
import com.dh.Xplorando.service.IProductoService;
import com.dh.Xplorando.service.IReservaService;
import com.dh.Xplorando.service.IUserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    ReservaRepository repository;
    @Autowired
    ProductoService productoService;
    @Autowired
    UserService userService;
    //inicializamos los servicios

    //agregar reservas:
    public Reserva agregarReserva(Reserva reserva)  {

        Optional<Producto> productoBuscado=productoService.buscarProductoXId(reserva.getProducto().getId());
        reserva.setProducto(productoBuscado.get());

        Optional <User> usuarioBuscado= Optional.ofNullable(userService.getUserId(reserva.getUsuario().getId()));

        reserva.setUsuario(usuarioBuscado.get());
        System.out.println("reserva" +reserva );
        return repository.save(reserva);
    }
    //traer reservas (adicional)
    public List<Reserva> listarReservas(){
        return repository.findAll();
    }

    //buscar reserva X id:
    public Optional<Reserva> buscarReservaXId(Long id) {
        return repository.findById(id);
    }
    //buscar reserva por id de producto
    public Optional<List<Reserva>> listarReservasXProductoId(Long id) {
        return repository.findAllByProductoId(id);

    }
    //buscar reserva por id de usuario
    public Optional<List<Reserva>> listarReservasXUsuarioId(Long id){
        return repository.findAllByUsuarioId(id);
    }

    //editar reserva (opcional):
    public Reserva editarReserva(Reserva reserva) throws ResourceNotFoundException {
        Optional<Reserva> reservaBuscada = buscarReservaXId(reserva.getId());
        Optional<Producto> productoBuscado=productoService.buscarProductoXId(reserva.getProducto().getId());
        if (reservaBuscada.isPresent() && productoBuscado.isPresent()) {
            return repository.save(reserva);
        } else {
            throw new ResourceNotFoundException("No se pudo actualizar la Reserva con id " + reserva.getId() +
                    "con hora : " + reserva.getHora() + " con fecha de inicio : " + reserva.getFechaInicio() + "y fecha final : " +
                    reserva.getFechaFinal() + "por que no se encontraron los datos necesarios para realizar la peticion. ");
        }

    }
    //eliminar Reserva (Opcional)
    public void eliminarReservaXId(Long id) throws ResourceNotFoundException{
        Optional<Reserva> reservaBuscada = buscarReservaXId(id);
        if (reservaBuscada.isPresent()){
            repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe la reserva con id :"+id+"no se puede borrar.");
        }
    }
}