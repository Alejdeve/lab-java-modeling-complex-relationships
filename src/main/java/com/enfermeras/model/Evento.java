package com.enfermeras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private int duracion;
    private String ubicacion;
    private String titulo;

    @OneToMany(mappedBy = "evento")
    private List<Invitado> invitados;
}