package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@DiscriminatorValue("TECHNICIAN")
public class TechnicienIT extends Personne {


    @OneToMany(mappedBy = "technicien")
    private List<TicketDeSupport> ticketsSupport;

    @OneToMany(mappedBy = "technicienIT")
    private List<Rapport> reports;
}