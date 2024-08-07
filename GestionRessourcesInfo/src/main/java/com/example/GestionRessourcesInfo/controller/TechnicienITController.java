package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.TechnicienIT;
import com.example.GestionRessourcesInfo.service.TechnicienITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/techniciens")
public class TechnicienITController {

    @Autowired
    private TechnicienITService technicienITService;

    @PostMapping("/register")
    public ResponseEntity<?> registerTechnicien(@RequestBody TechnicienIT technicien) {
        TechnicienIT newTechnicien = technicienITService.registerTechnicien(technicien);
        return ResponseEntity.ok(newTechnicien);
    }

    @GetMapping
    public ResponseEntity<List<TechnicienIT>> getAllTechniciens() {
        List<TechnicienIT> techniciens = technicienITService.getAllTechniciens();
        return ResponseEntity.ok(techniciens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTechnicienById(@PathVariable Long id) {
        Optional<TechnicienIT> technicien = technicienITService.getTechnicienById(id);
        return technicien.isPresent() ? ResponseEntity.ok(technicien.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTechnicien(@PathVariable Long id, @RequestBody TechnicienIT updatedTechnicien) {
        TechnicienIT technicien = technicienITService.updateTechnicien(id, updatedTechnicien);
        return technicien != null ? ResponseEntity.ok(technicien) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTechnicien(@PathVariable Long id) {
        technicienITService.deleteTechnicien(id);
        return ResponseEntity.ok("Technicien deleted successfully");
    }
}
