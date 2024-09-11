package com.enfermeras.Controller;

import com.enfermeras.model.Evento;
import com.enfermeras.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return evento != null ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.saveEvento(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        Evento evento = eventoService.getEventoById(id);
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        evento.setFecha(eventoDetails.getFecha());
        evento.setDuracion(eventoDetails.getDuracion());
        evento.setUbicacion(eventoDetails.getUbicacion());
        evento.setTitulo(eventoDetails.getTitulo());
        evento.setInvitados(eventoDetails.getInvitados());
        return ResponseEntity.ok(eventoService.saveEvento(evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.deleteEvento(id);
        return ResponseEntity.ok().build();
    }
}
