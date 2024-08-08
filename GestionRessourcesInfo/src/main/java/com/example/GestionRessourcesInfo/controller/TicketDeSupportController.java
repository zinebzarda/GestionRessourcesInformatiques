package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.TicketDeSupport;
import com.example.GestionRessourcesInfo.service.TicketDeSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketDeSupportController {

    @Autowired
    private TicketDeSupportService ticketDeSupportService;

    @PostMapping
    public ResponseEntity<TicketDeSupport> creerTicketDeSupport(@RequestBody TicketDeSupport ticketDeSupport) {
        TicketDeSupport createdTicket = ticketDeSupportService.creerTicketDeSupport(ticketDeSupport);
        return ResponseEntity.ok(createdTicket);
    }

    @GetMapping
    public ResponseEntity<List<TicketDeSupport>> getAllTicketsDeSupport() {
        List<TicketDeSupport> tickets = ticketDeSupportService.getAllTicketsDeSupport();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDeSupport> getTicketDeSupportById(@PathVariable Long id) {
        TicketDeSupport ticket = ticketDeSupportService.getTicketDeSupportById(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDeSupport> updateTicketDeSupport(@PathVariable Long id, @RequestBody TicketDeSupport ticketDeSupport) {
        ticketDeSupport.setId(id);
        TicketDeSupport updatedTicket = ticketDeSupportService.updateTicketDeSupport(ticketDeSupport);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketDeSupport(@PathVariable Long id) {
        ticketDeSupportService.deleteTicketDeSupport(id);
        return ResponseEntity.noContent().build();
    }
}
