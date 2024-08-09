package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@DiscriminatorValue("TECHNICIAN")
public class TechnicienIT extends Personne {

    @OneToMany(mappedBy = "technicienIT")
    private List<TicketDeSupport> ticketsSupport;

    @OneToMany(mappedBy = "technicienIT")
    private List<Rapport> reports;
}
