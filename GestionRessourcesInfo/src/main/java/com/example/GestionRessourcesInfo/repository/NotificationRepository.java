package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByAdministrateurIdAndLu(Long administrateurId, boolean lu);
}