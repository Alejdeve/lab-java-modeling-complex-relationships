package com.enfermeras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private EstadoMiembro estado;

    private LocalDate fechaRenovacion;

    @ManyToOne
    @JoinColumn(name = "capitulo_id")
    private Capitulo capitulo;

    public enum EstadoMiembro {
        ACTIVO, CADUCADO
    }
}
