package com.enfermeras.Controller;

import com.enfermeras.model.Miembro;
import com.enfermeras.Service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @GetMapping
    public List<Miembro> getAllMiembros() {
        return miembroService.getAllMiembros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembro> getMiembroById(@PathVariable Long id) {
        Miembro miembro = miembroService.getMiembroById(id);
        return miembro != null ? ResponseEntity.ok(miembro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Miembro createMiembro(@RequestBody Miembro miembro) {
        return miembroService.saveMiembro(miembro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembro> updateMiembro(@PathVariable Long id, @RequestBody Miembro miembroDetails) {
        Miembro miembro = miembroService.getMiembroById(id);
        if (miembro == null) {
            return ResponseEntity.notFound().build();
        }
        miembro.setNombre(miembroDetails.getNombre());
        miembro.setEstado(miembroDetails.getEstado());
        miembro.setFechaRenovacion(miembroDetails.getFechaRenovacion());
        miembro.setCapitulo(miembroDetails.getCapitulo());
        return ResponseEntity.ok(miembroService.saveMiembro(miembro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMiembro(@PathVariable Long id) {
        Miembro miembro = miembroService.getMiembroById(id);
        if (miembro == null) {
            return ResponseEntity.notFound().build();
        }
        miembroService.deleteMiembro(id);
        return ResponseEntity.ok().build();
    }
}
