package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.Panne;
import com.example.GestionRessourcesInfo.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pannes")
public class PanneController {

    @Autowired
    private PanneService panneService;

    @PostMapping
    public ResponseEntity<Panne> creerPanne(@RequestBody Panne panne) {
        return ResponseEntity.ok(panneService.creerPanne(panne));
    }

    @GetMapping
    public ResponseEntity<List<Panne>> getAllPannes() {
        return ResponseEntity.ok(panneService.getAllPannes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Panne> getPanneById(@PathVariable Long id) {
        Panne panne = panneService.getPanneById(id);
        if (panne != null) {
            return ResponseEntity.ok(panne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Panne> updatePanne(@PathVariable Long id, @RequestBody Panne panne) {
        panne.setId(id);
        return ResponseEntity.ok(panneService.updatePanne(panne));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        panneService.deletePanne(id);
        return ResponseEntity.noContent().build();
    }
}