package com.example.GestionRessourcesInfo.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur extends Personne {

    @Column(nullable = false)
    private String motDePasse;

}