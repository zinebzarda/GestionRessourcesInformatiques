
package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.EtatTicket;
import com.example.GestionRessourcesInfo.model.TicketDeSupport;
import com.example.GestionRessourcesInfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<TicketDeSupport> createTicket(@RequestBody TicketDeSupport ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDeSupport>> getTicketsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.getTicketsByUserId(userId));
    }

    @GetMapping("/technicien/{technicienId}")
    public ResponseEntity<List<TicketDeSupport>> getTicketsByTechnicienId(@PathVariable Long technicienId) {
        return ResponseEntity.ok(ticketService.getTicketsByTechnicienId(technicienId));
    }

    @PreAuthorize("hasRole('TECHNICIEN')")
    @PutMapping("/update-status/{technicienId}/{ticketId}")
    public ResponseEntity<String> updateTicketStatus(
            @PathVariable Long technicienId,
            @PathVariable Long ticketId,
            @RequestBody Map<String, String> requestBody) {
        String etatTicketStr = requestBody.get("etatTicket");
        EtatTicket etatTicket = EtatTicket.valueOf(etatTicketStr);
        ticketService.updateTicketStatus(ticketId, etatTicket);
        return ResponseEntity.ok("Ticket status updated successfully");
    }

}
