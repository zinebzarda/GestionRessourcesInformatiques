package com.example.GestionRessourcesInfo.controller;


import com.example.GestionRessourcesInfo.model.Rapport;
import com.example.GestionRessourcesInfo.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rapports")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @PostMapping
    public ResponseEntity<Rapport> creerRapport(@RequestBody Rapport rapport) {
        return ResponseEntity.ok(rapportService.creerRapport(rapport));
    }

    @GetMapping
    public ResponseEntity<List<Rapport>> getAllRapports() {
        return ResponseEntity.ok(rapportService.getAllRapports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable Long id) {
        Rapport rapport = rapportService.getRapportById(id);
        if (rapport != null) {
            return ResponseEntity.ok(rapport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable Long id, @RequestBody Rapport rapport) {
        rapport.setId(id);
        return ResponseEntity.ok(rapportService.updateRapport(rapport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Long id) {
        rapportService.deleteRapport(id);
        return ResponseEntity.noContent().build();
    }
}