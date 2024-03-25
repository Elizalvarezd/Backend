package com.dh.Xplorando.dto.entrada;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UbicacionEntradaDto {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "Debe completar con un nombre de Ciudad")
    private String ciudad;
    @NotNull(message = "El pais no puede ser nulo")
    @NotBlank(message = "Debe completar con una ciudad de Pais")
    private String pais;

}