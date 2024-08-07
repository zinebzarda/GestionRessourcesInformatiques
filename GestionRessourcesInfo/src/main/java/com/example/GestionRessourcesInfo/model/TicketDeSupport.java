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
@Table(name = "tickets_de_support")
public class TicketDeSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EtatTicket etat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateResolution;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur creePar;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private TechnicienIT assigneA;

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;

}