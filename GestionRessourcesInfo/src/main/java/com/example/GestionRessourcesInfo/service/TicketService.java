

package com.example.GestionRessourcesInfo.service;
import com.example.GestionRessourcesInfo.model.EtatTicket;
import com.example.GestionRessourcesInfo.model.TicketDeSupport;
import com.example.GestionRessourcesInfo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDeSupport createTicket(TicketDeSupport ticket) {
        ticket.setDateCreation(new Date());
        return ticketRepository.save(ticket);
    }


    public List<TicketDeSupport> getTicketsByUserId(Long userId) {
        return ticketRepository.findByUserId(userId);
    }

    public List<TicketDeSupport> getTicketsByTechnicienId(Long technicienId) {
        return ticketRepository.findByTechnicienId(technicienId);
    }

    public void updateTicketStatus(Long id, EtatTicket etatTicket) {
        TicketDeSupport ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setEtatTicket(etatTicket);
        ticketRepository.save(ticket);
    }
}
