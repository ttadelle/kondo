package com.kondo.controllers;

import com.kondo.DTO.TicketActionHistoryDTO;
import com.kondo.services.TicketActionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/actions")
public class TickerActionHistoryController {

    private static final Logger log = Logger.getLogger(String.valueOf(TickerActionHistoryController.class));


    @Autowired
    private TicketActionHistoryService ticketActionHistoryService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<List<TicketActionHistoryDTO>> findByTicketId(@PathVariable Long id) {
        List<TicketActionHistoryDTO> dto = ticketActionHistoryService.findByTicketId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<TicketActionHistoryDTO> insert(@PathVariable(value = "id") Long id, @RequestBody TicketActionHistoryDTO dto) {
        dto = ticketActionHistoryService.insert(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
