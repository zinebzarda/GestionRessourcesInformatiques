
package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.TicketDeSupport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketDeSupport, Long> {
    List<TicketDeSupport> findByUserId(Long userId);
    List<TicketDeSupport> findByTechnicienId(Long technicienId);
}
