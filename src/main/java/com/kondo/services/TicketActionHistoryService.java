package com.kondo.services;

import com.kondo.DTO.TicketActionHistoryDTO;
import com.kondo.entities.Ticket;
import com.kondo.entities.TicketActionHistory;
import com.kondo.entities.enums.TicketStatus;
import com.kondo.entities.enums.exceptions.InvalidTicketStatusException;
import com.kondo.repositories.TicketActionHistoryRepository;
import com.kondo.repositories.TicketRepository;
import com.kondo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketActionHistoryService {

    @Autowired
    private TicketActionHistoryRepository ticketActionHistoryRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService;

    @Transactional(readOnly = true)
    public List<TicketActionHistoryDTO> findByTicketId(Long id) {
        List<TicketActionHistory> entity = ticketActionHistoryRepository.findByTicketId(id);
        return entity.stream().map(x -> (new TicketActionHistoryDTO(x))).collect(Collectors.toList());
    }

    @Transactional
    public TicketActionHistoryDTO insert(Long id, TicketActionHistoryDTO dto) {
        TicketActionHistory entity = new TicketActionHistory();
        TicketStatus status = null;

        try {
            ticketRepository.getReferenceById(id);
            TicketStatus.fromValue(dto.getTicketStatusId());
            copyDtoToEntity(dto, entity);
            entity.setTicketId(id);
            ticketActionHistoryRepository.save(entity);
            ticketService.update(id, dto.getTicketStatusId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Entity id " + id + " not found.");
        }

        return new TicketActionHistoryDTO(entity);
    }

    private void copyDtoToEntity(TicketActionHistoryDTO dto, TicketActionHistory entity) {

        entity.setDescription(dto.getDescription());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setLastUpdatedBy(dto.getLastUpdatedBy());
        try {
            entity.setTicketStatus(TicketStatus.fromValue(dto.getTicketStatusId()));
        } catch (HttpMessageNotReadableException e) {
            throw e;
        }

    }
}
