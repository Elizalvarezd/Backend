package com.dh.Xplorando.service.impl;

import com.dh.Xplorando.dto.entrada.UbicacionEntradaDto;
import com.dh.Xplorando.dto.salida.UbicacionSalidaDto;
import com.dh.Xplorando.entity.Ubicacion;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;
import com.dh.Xplorando.repository.UbicacionRepository;
import com.dh.Xplorando.service.IUbicacionService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements IUbicacionService {
    private final Logger LOGGER = LoggerFactory.getLogger(UbicacionService.class);
    private final UbicacionRepository ubicacionRepository;
    private final ModelMapper modelMapper;

    public UbicacionService(UbicacionRepository ubicacionRepository, ModelMapper modelMapper) {
        this.ubicacionRepository = ubicacionRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public UbicacionSalidaDto crearUbicacion(UbicacionEntradaDto ubicacionEntradaDto)  {
        Ubicacion ubicacionRecibida = dtoEntradaAentidad(ubicacionEntradaDto);
        Ubicacion ubicacionRegistrada = ubicacionRepository.save(ubicacionRecibida);
        UbicacionSalidaDto ubicacionResultado = entidadAdtoSalida(ubicacionRegistrada);
        LOGGER.info("Ubicacion registrada: " + ubicacionRegistrada);
        return ubicacionResultado;
    }
    @Override
    public List<UbicacionSalidaDto> listarUbicaciones() {

        List<UbicacionSalidaDto> ubicaciones = ubicacionRepository.findAll().stream().map(this::entidadAdtoSalida).toList();
        LOGGER.info("LISTA DE LAS UBICACIONES DISPONIBLES : {}", ubicaciones);
        return ubicaciones;

    }

    @Override
    public List<UbicacionSalidaDto> buscarUbicacionXId(Long id){
        List<UbicacionSalidaDto> ubicaciones = ubicacionRepository.findById(id).stream().map(this::entidadAdtoSalida).toList();
        LOGGER.info("LISTA DE LAS UBICACIONES POR ID : {}", ubicaciones);
        return ubicaciones;
    }

    //MAPEO
    public Ubicacion dtoEntradaAentidad(UbicacionEntradaDto ubicacionEntradaDto){
        return modelMapper.map(ubicacionEntradaDto, Ubicacion.class);
    }

    public UbicacionSalidaDto entidadAdtoSalida(Ubicacion ubicacion){
        return modelMapper.map(ubicacion, UbicacionSalidaDto.class);
    }

}