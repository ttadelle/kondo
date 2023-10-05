package com.kondo.services;

import com.kondo.DTO.TicketDTO;
import com.kondo.entities.Ticket;
import com.kondo.entities.enums.TicketStatus;
import com.kondo.repositories.TicketRepository;
import com.kondo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public TicketDTO findById(Long id) {
        Optional<Ticket> obj = ticketRepository.findById(id);
        Ticket entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new TicketDTO(entity);
    }

    @Transactional
    public List<TicketDTO> findByCreatedBy(Long id) {
      List<Ticket> tickets = ticketRepository.findByCreatedBy(id);
      return tickets.stream().map(x -> new TicketDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public TicketDTO insert(TicketDTO dto) {
        Ticket entity = new Ticket();
        copyDtoToEntity(dto, entity);
        ticketRepository.save(entity);
        return new TicketDTO(entity);
    }

    @Transactional
    public TicketDTO update(Long id, int status) {

        try {
                Ticket entity = ticketRepository.getReferenceById(id);
                entity.setTicketStatus(TicketStatus.fromValue(status));
                ticketRepository.save(entity);
                return new TicketDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Entity id " + id + " not found.");
        }
    }

    private void copyDtoToEntity(TicketDTO dto, Ticket entity) {
        entity.setTicketNumber(dto.getTicketNumber());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setTicketStatus(TicketStatus.OPEN);
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setLastUpdatedBy(dto.getLastUpdatedBy());
    }
}
