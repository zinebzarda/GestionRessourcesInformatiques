package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.*;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Technicien")
@PrimaryKeyJoinColumn(name = "id")
public class TechnicienIT extends Personne {
    @Column(name = "specialite")
    private String specialite;

    @Override
    public String getRole() {
        return "ROLE_TECHNICIEN";
    }
    public TechnicienIT() {
        super();
        this.setRole("ROLE_TECHNICIEN");
    }

}