package com.dh.Xplorando.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="UBICACIONES")
public class Ubicacion {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name="CIUDAD", unique = true)
        private String ciudad;

        @Column(name="PAIS")
        private String pais;
        @OneToMany(mappedBy = "ubicacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Producto> productos ;
}