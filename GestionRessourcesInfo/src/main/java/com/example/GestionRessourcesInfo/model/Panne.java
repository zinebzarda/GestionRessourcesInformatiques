package com.example.GestionRessourcesInfo.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    private String description;
    private LocalDateTime datePanne;

    @Enumerated(EnumType.STRING)
    private EtatPanne etatPanne;

    @OneToMany(mappedBy = "panne")
    private List<PanneEquipment> panneEquipments;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

}
