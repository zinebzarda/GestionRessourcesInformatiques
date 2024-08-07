package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.*;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "techniciens_it")
public class TechnicienIT extends Personne {

    @Column(nullable = false)
    private String specialite;



}