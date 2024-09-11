package com.enfermeras.Service;

import com.enfermeras.model.Miembro;
import com.enfermeras.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    public List<Miembro> getAllMiembros() {
        return miembroRepository.findAll();
    }

    public Miembro getMiembroById(Long id) {
        return miembroRepository.findById(id).orElse(null);
    }

    public Miembro saveMiembro(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    public void deleteMiembro(Long id) {
        miembroRepository.deleteById(id);
    }
}
