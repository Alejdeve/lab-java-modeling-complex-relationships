package com.enfermeras.Service;

import com.enfermeras.model.Evento;
import com.enfermeras.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Evento getEventoById(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public Evento saveEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
