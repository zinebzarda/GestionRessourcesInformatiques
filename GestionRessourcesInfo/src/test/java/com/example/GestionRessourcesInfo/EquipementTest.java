//package com.example.GestionRessourcesInfo;
//
//import com.example.GestionRessourcesInfo.model.Equipement;
//import com.example.GestionRessourcesInfo.model.enums.EtatEquipement;
//import com.example.GestionRessourcesInfo.repository.EquipementRepository;
//import com.example.GestionRessourcesInfo.service.EquipementService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@Import(EquipementService.class)
//class EquipementTest {
//
//    @Autowired
//    private EquipementService equipementService;
//
//    @Autowired
//    private EquipementRepository equipementRepository;
//
//    private Equipement equipement;
//
//    @BeforeEach
//    void setUp() {
//        equipement = new Equipement();
//        equipement.setNom("Ordinateur");
//        equipement.setDescription("Ordinateur portable");
//        equipement.setEtat(EtatEquipement.EN_PANNE);
//        equipement.setDateAcquisition(new Date());
//    }
//    @Test
//    void creerEquipement() {
//        Equipement createdEquipement = equipementService.creerEquipement(equipement);
//
//        assertNotNull(createdEquipement);
//        assertEquals(equipement.getNom(), createdEquipement.getNom());
//        assertEquals(equipement.getDescription(), createdEquipement.getDescription());
//        assertEquals(equipement.getEtat(), createdEquipement.getEtat());
//        assertEquals(equipement.getDateAcquisition(), createdEquipement.getDateAcquisition());
//    }
//
//    @Test
//    void getAllEquipements() {
//        equipementService.creerEquipement(equipement);
//        List<Equipement> equipements = equipementService.getAllEquipements();
//
//        assertFalse(equipements.isEmpty());
//        assertEquals(1, equipements.size());
//    }
//
//    @Test
//    void getEquipementById_Found() {
//        Equipement savedEquipement = equipementService.creerEquipement(equipement);
//
//        Equipement foundEquipement = equipementService.getEquipementById(savedEquipement.getId());
//
//        assertNotNull(foundEquipement);
//        assertEquals(savedEquipement.getId(), foundEquipement.getId());
//    }
//
//    @Test
//    void getEquipementById_NotFound() {
//        assertNull(equipementService.getEquipementById(999L));
//    }
//
//    @Test
//    void updateEquipement() {
//        Equipement savedEquipement = equipementService.creerEquipement(equipement);
//        savedEquipement.setNom("Ordinateur modifié");
//        savedEquipement.setDescription("Description modifiée");
//        savedEquipement.setEtat(EtatEquipement.HORS_SERVICE);
//        savedEquipement.setDateAcquisition(new Date());
//
//        Equipement updatedEquipement = equipementService.updateEquipement(savedEquipement);
//
//        assertEquals("Ordinateur modifié", updatedEquipement.getNom());
//        assertEquals("Description modifiée", updatedEquipement.getDescription());
//        assertEquals(EtatEquipement.HORS_SERVICE, updatedEquipement.getEtat());
//        assertEquals(savedEquipement.getDateAcquisition(), updatedEquipement.getDateAcquisition());
//    }
//
//    @Test
//    void deleteEquipement() {
//        Equipement savedEquipement = equipementService.creerEquipement(equipement);
//
//        equipementService.deleteEquipement(savedEquipement.getId());
//
//        assertNull(equipementService.getEquipementById(savedEquipement.getId()));
//    }
//}