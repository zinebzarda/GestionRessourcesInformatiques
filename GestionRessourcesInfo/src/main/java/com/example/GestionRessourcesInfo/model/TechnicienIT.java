package com.example.GestionRessourcesInfo.model;

import com.example.GestionRessourcesInfo.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("TECHNICIAN")
public class TechnicienIT extends Personne {

    public TechnicienIT(Long id, String username, String email, String password, Role role, Role role1, List<TicketDeSupport> ticketsSupport, List<Rapport> reports) {
        super(id, username, email, password, role);
        this.role = role1;
        this.ticketsSupport = ticketsSupport;
        this.reports = reports;
    }

    public TechnicienIT(Role role, List<TicketDeSupport> ticketsSupport, List<Rapport> reports) {
        this.role = role;
        this.ticketsSupport = ticketsSupport;
        this.reports = reports;
    }

    @Enumerated(EnumType.STRING)
    private Role role = Role.TECHNICIAN;


    @OneToMany(mappedBy = "technicienIT")
    @JsonIgnore
    private List<TicketDeSupport> ticketsSupport;

    @OneToMany(mappedBy = "technicienIT")
    @JsonIgnore
    private List<Rapport> reports;
}
