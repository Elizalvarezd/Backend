package com.dh.Xplorando.service;




import com.dh.Xplorando.dto.entrada.ProductoEntradaDto;
import com.dh.Xplorando.dto.entrada.UbicacionEntradaDto;
import com.dh.Xplorando.dto.salida.ImagenSalidaDto;
import com.dh.Xplorando.dto.salida.ProductoSalidaDto;
import com.dh.Xplorando.dto.salida.UbicacionSalidaDto;
import com.dh.Xplorando.entity.Ubicacion;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface IUbicacionService {
    List<UbicacionSalidaDto> listarUbicaciones();

    UbicacionSalidaDto crearUbicacion(UbicacionEntradaDto ubicacionEntradaDto) throws BadRequestException;


    List<UbicacionSalidaDto> buscarUbicacionXId(Long id);

}