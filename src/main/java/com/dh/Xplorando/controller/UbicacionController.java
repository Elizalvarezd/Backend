package com.dh.Xplorando.controller;

import com.dh.Xplorando.dto.entrada.UbicacionEntradaDto;
import com.dh.Xplorando.dto.salida.ProductoSalidaDto;
import com.dh.Xplorando.dto.salida.UbicacionSalidaDto;
import com.dh.Xplorando.entity.Ubicacion;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;

import com.dh.Xplorando.service.IUbicacionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    private final IUbicacionService iUbicacionService;

    public UbicacionController(IUbicacionService iUbicacionService) {
        this.iUbicacionService = iUbicacionService;
    }


    @PostMapping("/crear")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UbicacionSalidaDto> crearUbicacion(@Valid @RequestBody UbicacionEntradaDto ubicacionEntradaDto) throws BadRequestException {
        return new ResponseEntity<>(iUbicacionService.crearUbicacion(ubicacionEntradaDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UbicacionSalidaDto>> listarUbicaciones() throws ResourceNotFoundException {
        return new ResponseEntity<>(iUbicacionService.listarUbicaciones(),HttpStatus.OK);
    }

    //get por id
    @Operation(summary = "Buscar ubicacion por id")
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<List<UbicacionSalidaDto>> buscarUbicacionPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(iUbicacionService.buscarUbicacionXId(id),HttpStatus.OK);

    }

}