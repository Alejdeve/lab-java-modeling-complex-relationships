package com.enfermeras.Controller;

import com.enfermeras.model.Capitulo;
import com.enfermeras.Service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capitulos")
public class CapituloController {

    @Autowired
    private CapituloService capituloService;

    @GetMapping
    public List<Capitulo> getAllCapitulos() {
        return capituloService.getAllCapitulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capitulo> getCapituloById(@PathVariable Long id) {
        Capitulo capitulo = capituloService.getCapituloById(id);
        return capitulo != null ? ResponseEntity.ok(capitulo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Capitulo createCapitulo(@RequestBody Capitulo capitulo) {
        return capituloService.saveCapitulo(capitulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Capitulo> updateCapitulo(@PathVariable Long id, @RequestBody Capitulo capituloDetails) {
        Capitulo capitulo = capituloService.getCapituloById(id);
        if (capitulo == null) {
            return ResponseEntity.notFound().build();
        }
        capitulo.setNombre(capituloDetails.getNombre());
        capitulo.setDistrito(capituloDetails.getDistrito());
        capitulo.setPresidente(capituloDetails.getPresidente());
        capitulo.setMiembros(capituloDetails.getMiembros());
        return ResponseEntity.ok(capituloService.saveCapitulo(capitulo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCapitulo(@PathVariable Long id) {
        Capitulo capitulo = capituloService.getCapituloById(id);
        if (capitulo == null) {
            return ResponseEntity.notFound().build();
        }
        capituloService.deleteCapitulo(id);
        return ResponseEntity.ok().build();
    }
}
