package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "administrateurs_it")
public class AdministrateurIT extends Personne {

    private String departement;

    @Override
    public String getRole() {
        return "ROLE_ADMIN";
    }
    public AdministrateurIT() {
        this.setRole("ROLE_ADMIN");
    }

}
