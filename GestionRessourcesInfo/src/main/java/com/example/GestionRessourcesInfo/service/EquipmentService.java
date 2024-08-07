package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.Equipement;
import com.example.GestionRessourcesInfo.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public Equipement addEquipment(Equipement equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipement updateEquipment(Long id, Equipement equipmentDetails) {
        Equipement equipment = equipmentRepository.findById(id).orElseThrow();
        equipment.setNom(equipmentDetails.getNom());
        equipment.setType(equipmentDetails.getType());
        equipment.setEtatEquipement(equipmentDetails.getEtatEquipement());
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    public List<Equipement> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Equipement getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
    }
}
