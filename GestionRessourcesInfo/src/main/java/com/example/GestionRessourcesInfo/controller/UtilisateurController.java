package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.service.CustomUserDetailsService;
import com.example.GestionRessourcesInfo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

//
//    @PostMapping
//    public ResponseEntity<UtilisateurDTO> creerUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
//        return ResponseEntity.ok(utilisateurService.creerUtilisateur(utilisateurDTO));
//    }

//    @GetMapping
//    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {
//        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
//    }
}