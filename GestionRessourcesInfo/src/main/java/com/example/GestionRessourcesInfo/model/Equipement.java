package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipements")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;

    @Enumerated(EnumType.STRING)
    private EtatEquipement etatEquipement;

    @OneToMany(mappedBy = "equipment")
    private List<PanneEquipment> panneEquipments;

    @OneToMany(mappedBy = "equipment")
    private List<TicketDeSupport> tickets;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
