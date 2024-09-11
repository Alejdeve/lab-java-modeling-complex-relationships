package com.enfermeras.Service;


import com.enfermeras.model.Capitulo;
import com.enfermeras.repository.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapituloService {

    @Autowired
    private CapituloRepository capituloRepository;

    public List<Capitulo> getAllCapitulos() {
        return capituloRepository.findAll();
    }

    public Capitulo getCapituloById(Long id) {
        return capituloRepository.findById(id).orElse(null);
    }

    public Capitulo saveCapitulo(Capitulo capitulo) {
        return capituloRepository.save(capitulo);
    }

    public void deleteCapitulo(Long id) {
        capituloRepository.deleteById(id);
    }
}
