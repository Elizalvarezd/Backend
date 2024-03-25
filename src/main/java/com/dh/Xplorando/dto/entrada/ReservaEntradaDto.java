package com.dh.Xplorando.dto.entrada;

import com.dh.Xplorando.entity.Producto;
import com.dh.Xplorando.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservaEntradaDto {

    @NotNull(message = "El codigo no puede ser nulo")
    @Digits(integer = 10,fraction = 0,message = "El codigo no debe contener más de 10 digitos")
    private Long id;
    @NotNull(message = "La hora no puede ser nulo")
    @NotBlank(message ="Debe completar con una hora" )
    private LocalTime hora;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Ingrese una fecha correcta. No puede ingresar una fecha anterior al día de hoy")
    @NotNull(message = "La fecha inicio no puede ser nulo")
    private LocalDate fechaInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Ingrese una fecha correcta. No puede ingresar una fecha anterior al día de hoy")
    @NotNull(message = "Ingrese una fecha final")
    private LocalDate fechaFinal;

    @NotNull(message = "El paquete del producto no puede ser nulo")
    @JsonProperty("producto")
    private Long productoId;

    @NotNull(message = "El usuario debe ser su correo")
    @JsonProperty("user")
    private String email;;


    @NotNull(message = "Los datos extras no pueden ser nulos")
    @NotBlank(message ="Debe completar los datos extra" )
    private String datosExtra;
    @NotNull(message = "A a pregunta de estar vacunado no puede ser nulo")
    @NotBlank(message ="Debe completar si esta o no vacunado" )
    private boolean vacunado;
}
