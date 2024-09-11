package com.enfermeras.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Conferencia extends Evento {
    @OneToMany(mappedBy = "conferencia")
    private List<Orador> oradores;
}
