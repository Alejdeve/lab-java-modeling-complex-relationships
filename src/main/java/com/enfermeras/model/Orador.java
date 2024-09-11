package com.enfermeras.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Orador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int duracionPresentacion;

    @ManyToOne
    @JoinColumn(name = "conferencia_id")
    private Conferencia conferencia;
}
