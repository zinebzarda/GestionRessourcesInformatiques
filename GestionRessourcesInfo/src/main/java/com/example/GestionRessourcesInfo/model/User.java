package com.example.GestionRessourcesInfo.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class User extends Personne {
    private String fonction;

    @OneToMany(mappedBy = "user")
    private List<TicketDeSupport> tickets;

    @Override
    public String getRole() {
        return "ROLE_USER";
    }
    public User() {
        this.setRole("ROLE_USER");
    }

}