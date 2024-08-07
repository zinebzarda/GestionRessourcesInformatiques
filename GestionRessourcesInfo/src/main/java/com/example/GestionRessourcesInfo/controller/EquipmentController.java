package com.example.GestionRessourcesInfo.controller;


import com.example.GestionRessourcesInfo.model.Equipement;
import com.example.GestionRessourcesInfo.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/add")
    public ResponseEntity<Equipement> addEquipment(@RequestBody Equipement equipement) {
        return ResponseEntity.ok(equipmentService.addEquipment(equipement));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Equipement> updateEquipment(@PathVariable Long id, @RequestBody Equipement equipmentDetails) {
        return ResponseEntity.ok(equipmentService.updateEquipment(id, equipmentDetails));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.ok("Equipment deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipement>> getAllEquipments() {
        return ResponseEntity.ok(equipmentService.getAllEquipments());
    }
}
