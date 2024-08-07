package com.example.GestionRessourcesInfo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PanneEquipment")
public class PanneEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

    private LocalDateTime dateOfLink;

}
