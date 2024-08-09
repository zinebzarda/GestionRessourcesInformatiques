package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Date dateEnvoi;
    private boolean lu;

    @ManyToOne
    @JoinColumn(name = "administrateur_id")
    private AdministrateurIT administrateurIT;
}