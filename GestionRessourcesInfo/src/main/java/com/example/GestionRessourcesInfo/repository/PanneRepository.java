package com.example.GestionRessourcesInfo.repository;


import com.example.GestionRessourcesInfo.model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanneRepository extends JpaRepository<Panne, Long> {
    List<Panne> findByEquipmentId(Long equipmentId);

}
