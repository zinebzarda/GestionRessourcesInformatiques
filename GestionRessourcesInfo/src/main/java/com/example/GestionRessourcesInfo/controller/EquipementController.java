package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.Equipement;
import com.example.GestionRessourcesInfo.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    @Autowired
    private EquipementService equipementService;

    @PostMapping
    public ResponseEntity<Equipement> creerEquipement(@RequestBody Equipement equipement) {
        return ResponseEntity.ok(equipementService.creerEquipement(equipement));
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        return ResponseEntity.ok(equipementService.getAllEquipements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Equipement equipement = equipementService.getEquipementById(id);
        if (equipement != null) {
            return ResponseEntity.ok(equipement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setId(id);
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}