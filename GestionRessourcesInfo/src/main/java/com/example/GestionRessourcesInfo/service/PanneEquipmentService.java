package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.PanneEquipment;
import com.example.GestionRessourcesInfo.repository.PanneEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PanneEquipmentService {

    @Autowired
    private PanneEquipmentRepository panneEquipmentRepository;

    public PanneEquipment savePanneEquipment(PanneEquipment panneEquipment) {
        return panneEquipmentRepository.save(panneEquipment);
    }

    public List<PanneEquipment> getAllPanneEquipments() {
        return panneEquipmentRepository.findAll();
    }

    public List<PanneEquipment> getPanneHistory(Long panneId) {
        return panneEquipmentRepository.findByPanne_Id(panneId);
    }

    public List<PanneEquipment> getEquipmentHistory(Long equipmentId) {
        return panneEquipmentRepository.findByEquipment_Id(equipmentId);
    }

    public Optional<PanneEquipment> getPanneEquipmentById(Long id) {
        return panneEquipmentRepository.findById(id);
    }

    public void deletePanneEquipment(Long id) {
        panneEquipmentRepository.deleteById(id);
    }
}
