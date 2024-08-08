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
        return ResponseEntity.ok(ticketDeSupportService.creerTicketDeSupport(ticketDeSupport));
    }

    @GetMapping
    public ResponseEntity<List<TicketDeSupport>> getAllTicketsDeSupport() {
        return ResponseEntity.ok(ticketDeSupportService.getAllTicketsDeSupport());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDeSupport> getTicketDeSupportById(@PathVariable Long id) {
        TicketDeSupport ticketDeSupport = ticketDeSupportService.getTicketDeSupportById(id);
        if (ticketDeSupport != null) {
            return ResponseEntity.ok(ticketDeSupport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDeSupport> updateTicketDeSupport(@PathVariable Long id, @RequestBody TicketDeSupport ticketDeSupport) {
        ticketDeSupport.setId(id);
        return ResponseEntity.ok(ticketDeSupportService.updateTicketDeSupport(ticketDeSupport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketDeSupport(@PathVariable Long id) {
        ticketDeSupportService.deleteTicketDeSupport(id);
        return ResponseEntity.noContent().build();
    }
}