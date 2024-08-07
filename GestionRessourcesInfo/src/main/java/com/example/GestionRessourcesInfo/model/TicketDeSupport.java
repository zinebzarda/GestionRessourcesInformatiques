package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String description;
    private Date dateCreation;
    @PrePersist
    protected void onCreate() {
        this.dateCreation = new Date();
    }
    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private TechnicienIT technicien;
    @Enumerated(EnumType.STRING)
    private EtatTicket etatTicket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;
    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;

}

