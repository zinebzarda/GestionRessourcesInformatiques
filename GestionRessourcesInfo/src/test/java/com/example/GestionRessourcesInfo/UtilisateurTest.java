//package com.example.GestionRessourcesInfo;
//
//import com.example.GestionRessourcesInfo.dto.UtilisateurDTO;
//import com.example.GestionRessourcesInfo.model.Utilisateur;
//import com.example.GestionRessourcesInfo.repository.UtilisateurRepository;
//import com.example.GestionRessourcesInfo.service.UtilisateurService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Import({UtilisateurService.class, PasswordEncoder.class})
//class UtilisateurTest {
//
//    @Autowired
//    private UtilisateurService utilisateurService;
//
//    @Autowired
//    private UtilisateurRepository utilisateurRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private UtilisateurDTO utilisateurDTO;
//
//    @BeforeEach
//    void setUp() {
//        utilisateurDTO = new UtilisateurDTO();
//        utilisateurDTO.setUsername("zineb");
//        utilisateurDTO.setEmail("zineb@example.com");
//        utilisateurDTO.setPassword("password123");
//    }
//
//    @Test
//    void creerUtilisateur() {
//        UtilisateurDTO createdUtilisateur = utilisateurService.creerUtilisateur(utilisateurDTO);
//
//        assertNotNull(createdUtilisateur);
//        assertEquals(utilisateurDTO.getUsername(), createdUtilisateur.getUsername());
//        assertEquals(utilisateurDTO.getEmail(), createdUtilisateur.getEmail());
//
//        Utilisateur utilisateur = utilisateurRepository.findById(createdUtilisateur.getId()).orElse(null);
//        assertNotNull(utilisateur);
//        assertTrue(passwordEncoder.matches("password123", utilisateur.getPassword()));
//    }
//
//    @Test
//    void getAllUtilisateurs() {
//        utilisateurService.creerUtilisateur(utilisateurDTO);
//
//        List<UtilisateurDTO> utilisateurs = utilisateurService.getAllUtilisateurs();
//
//        assertFalse(utilisateurs.isEmpty());
//        assertEquals(1, utilisateurs.size());
//        assertEquals(utilisateurDTO.getUsername(), utilisateurs.get(0).getUsername());
//    }
//}