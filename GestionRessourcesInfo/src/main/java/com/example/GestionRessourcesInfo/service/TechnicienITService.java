package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.TechnicienIT;
import com.example.GestionRessourcesInfo.repository.TechnicienITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienITService {

    @Autowired
    private TechnicienITRepository technicienITRepository;

    public TechnicienIT creerTechnicienIT(TechnicienIT technicienIT) {
        return technicienITRepository.save(technicienIT);
    }

    public List<TechnicienIT> getAllTechnicienITs() {
        return technicienITRepository.findAll();
    }

    public TechnicienIT getTechnicienITById(Long id) {
        return technicienITRepository.findById(id).orElse(null);
    }

    public TechnicienIT updateTechnicienIT(TechnicienIT technicienIT) {
        return technicienITRepository.save(technicienIT);
    }

    public void deleteTechnicienIT(Long id) {
        technicienITRepository.deleteById(id);
    }
}