package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "rapports")
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeRapport type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateGeneration;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenu;

}