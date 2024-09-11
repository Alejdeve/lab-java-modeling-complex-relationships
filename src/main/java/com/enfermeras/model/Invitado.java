package com.enfermeras.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Invitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private EstadoInvitado estado;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public enum EstadoInvitado {
        ASISTIRA, NO_ASISTIRA, SIN_RESPUESTA
    }
}
