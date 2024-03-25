package com.dh.Xplorando.service;

import com.dh.Xplorando.dto.entrada.ReservaEntradaDto;
import com.dh.Xplorando.dto.salida.ReservaSalidaDto;
import com.dh.Xplorando.entity.Reserva;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IReservaService {
    Reserva agregarReserva(Reserva reserva) throws  ResourceNotFoundException;
    List<Reserva> listarReservas();
    Optional<Reserva> buscarReservaXId(Long id) throws ResourceNotFoundException;
    Optional<List<Reserva>> listarReservasXProductoId(Long id);
    Optional<List<Reserva>> listarReservasXUsuarioId(Long id);
    Reserva editarReserva(Reserva reserva) throws ResourceNotFoundException;
    void eliminarReservaXId(Long id) throws ResourceNotFoundException;

}
