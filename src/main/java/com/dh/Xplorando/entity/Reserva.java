package com.dh.Xplorando.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalTime hora;
    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;
    @Column(name = "fechaFinal")
    private LocalDate fechaFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id")
    private User usuario;

    @Column(name = "datosExtra")
    private String datosExtra;
    @Column
    private boolean vacunado;
}
