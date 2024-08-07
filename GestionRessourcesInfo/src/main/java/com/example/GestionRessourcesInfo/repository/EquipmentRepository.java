package com.example.GestionRessourcesInfo.repository;


import com.example.GestionRessourcesInfo.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipement, Long> {
}
