package com.example.GestionRessourcesInfo.controller;


import com.example.GestionRessourcesInfo.model.TechnicienIT;
import com.example.GestionRessourcesInfo.service.TechnicienITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techniciens")
public class TechnicienITController {

    @Autowired
    private TechnicienITService technicienITService;

    @PostMapping
    public ResponseEntity<TechnicienIT> creerTechnicienIT(@RequestBody TechnicienIT technicienIT) {
        return ResponseEntity.ok(technicienITService.creerTechnicienIT(technicienIT));
    }

    @GetMapping
    public ResponseEntity<List<TechnicienIT>> getAllTechnicienITs() {
        return ResponseEntity.ok(technicienITService.getAllTechnicienITs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicienIT> getTechnicienITById(@PathVariable Long id) {
        TechnicienIT technicienIT = technicienITService.getTechnicienITById(id);
        if (technicienIT != null) {
            return ResponseEntity.ok(technicienIT);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicienIT> updateTechnicienIT(@PathVariable Long id, @RequestBody TechnicienIT technicienIT) {
        technicienIT.setId(id);
        return ResponseEntity.ok(technicienITService.updateTechnicienIT(technicienIT));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnicienIT(@PathVariable Long id) {
        technicienITService.deleteTechnicienIT(id);
        return ResponseEntity.noContent().build();
    }
}