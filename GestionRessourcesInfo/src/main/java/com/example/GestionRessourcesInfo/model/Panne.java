package com.example.GestionRessourcesInfo.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pannes")
public class Panne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date datePanne;

    @Column(nullable = false)
    private Boolean resolu;

    @ManyToOne
    @JoinColumn(name = "equipement_id", nullable = false)
    private Equipement equipement;
}
