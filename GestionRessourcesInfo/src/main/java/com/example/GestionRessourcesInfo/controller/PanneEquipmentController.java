package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.PanneEquipment;
import com.example.GestionRessourcesInfo.service.PanneEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/panne-equipment")
public class PanneEquipmentController {

    @Autowired
    private PanneEquipmentService panneEquipmentService;

    @PostMapping
    public ResponseEntity<PanneEquipment> createPanneEquipment(@RequestBody PanneEquipment panneEquipment) {
        PanneEquipment createdPanneEquipment = panneEquipmentService.savePanneEquipment(panneEquipment);
        return ResponseEntity.ok(createdPanneEquipment);
    }

    @GetMapping
    public ResponseEntity<List<PanneEquipment>> getAllPanneEquipments() {
        List<PanneEquipment> panneEquipments = panneEquipmentService.getAllPanneEquipments();
        return ResponseEntity.ok(panneEquipments);
    }

    @GetMapping("/panne/{panneId}")
    public ResponseEntity<List<PanneEquipment>> getPanneHistory(@PathVariable Long panneId) {
        List<PanneEquipment> panneHistory = panneEquipmentService.getPanneHistory(panneId);
        return ResponseEntity.ok(panneHistory);
    }

    @GetMapping("/equipment/{equipmentId}")
    public ResponseEntity<List<PanneEquipment>> getEquipmentHistory(@PathVariable Long equipmentId) {
        List<PanneEquipment> equipmentHistory = panneEquipmentService.getEquipmentHistory(equipmentId);
        return ResponseEntity.ok(equipmentHistory);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PanneEquipment>> getPanneEquipmentById(@PathVariable Long id) {
        Optional<PanneEquipment> panneEquipment = panneEquipmentService.getPanneEquipmentById(id);
        return ResponseEntity.ok(panneEquipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanneEquipment(@PathVariable Long id) {
        panneEquipmentService.deletePanneEquipment(id);
        return ResponseEntity.noContent().build();
    }
}
