package com.example.GestionRessourcesInfo.service;


import com.example.GestionRessourcesInfo.model.TechnicienIT;
import com.example.GestionRessourcesInfo.repository.TechnicienITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienITService {

    @Autowired
    private TechnicienITRepository technicienITRepository;

    public TechnicienIT registerTechnicien(TechnicienIT technicien) {
        return technicienITRepository.save(technicien);
    }

    public List<TechnicienIT> getAllTechniciens() {
        return technicienITRepository.findAll();
    }

    public Optional<TechnicienIT> getTechnicienById(Long id) {
        return technicienITRepository.findById(id);
    }

    public TechnicienIT updateTechnicien(Long id, TechnicienIT updatedTechnicien) {
        Optional<TechnicienIT> existingTechnicien = technicienITRepository.findById(id);
        if (existingTechnicien.isPresent()) {
            TechnicienIT technicien = existingTechnicien.get();
            technicien.setNom(updatedTechnicien.getNom());
            technicien.setPrenom(updatedTechnicien.getPrenom());
            technicien.setEmail(updatedTechnicien.getEmail());
            technicien.setSpecialite(updatedTechnicien.getSpecialite());
            return technicienITRepository.save(technicien);
        }
        return null;
    }

    public void deleteTechnicien(Long id) {
        technicienITRepository.deleteById(id);
    }
}
