package com.kondo.controllers;

import com.kondo.DTO.TicketDTO;
import com.kondo.entities.Ticket;
import com.kondo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Long id) {
        TicketDTO dto = ticketService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/list/{userId}")
    public ResponseEntity<List<TicketDTO>> findByCreatedBy(@PathVariable Long userId) {
        List<TicketDTO> tickets = ticketService.findByCreatedBy(userId);
        return ResponseEntity.ok().body(tickets);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> insert(@RequestBody TicketDTO dto) {
        dto = ticketService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
