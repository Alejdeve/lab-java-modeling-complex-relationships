package com.enfermeras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String distrito;

    @OneToOne
    @JoinColumn(name = "presidente_id")
    private Miembro presidente;

    @OneToMany(mappedBy = "capitulo")
    private List<Miembro> miembros;
}
