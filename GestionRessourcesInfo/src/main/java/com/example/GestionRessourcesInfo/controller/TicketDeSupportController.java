package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.TicketDeSupport;
import com.example.GestionRessourcesInfo.service.TicketDeSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/tickets")
public class TicketDeSupportController {

    @Autowired
    private TicketDeSupportService ticketDeSupportService;

    @PostMapping("/addTicket")
    public ResponseEntity<TicketDeSupport> createTicket(@RequestBody TicketDeSupport ticket) {
        try {
            TicketDeSupport savedTicket = ticketDeSupportService.creerTicketDeSupport(ticket);
            return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/afficher")
    public ResponseEntity<List<TicketDeSupport>> getAllTicketsDeSupport() {
        List<TicketDeSupport> tickets = ticketDeSupportService.getAllTicketsDeSupport();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDeSupport> getTicketDeSupportById(@PathVariable Long id) {
        TicketDeSupport ticket = ticketDeSupportService.getTicketDeSupportById(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TicketDeSupport> updateTicketDeSupport(@PathVariable Long id, @RequestBody TicketDeSupport ticketDeSupport) {
        ticketDeSupport.setId(id);
        TicketDeSupport updatedTicket = ticketDeSupportService.updateTicketDeSupport(ticketDeSupport);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicketDeSupport(@PathVariable Long id) {
        ticketDeSupportService.deleteTicketDeSupport(id);
        return ResponseEntity.noContent().build();
    }
}
