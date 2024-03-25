package com.dh.Xplorando.dto.salida;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaSalidaDto {

    private Long id;
    private LocalTime hora;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    @JsonProperty("producto")
    private String nombreProducto;

    @JsonProperty("user")
    private String email;;

    private String datosExtra;

    private boolean vacunado;
}
