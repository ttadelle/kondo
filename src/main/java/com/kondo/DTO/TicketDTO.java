package com.kondo.DTO;

import com.kondo.entities.Ticket;
import com.kondo.entities.enums.TicketStatus;

import java.time.Instant;
import java.util.Objects;

public class TicketDTO {

    private Long id;
    private String ticketNumber;
    private String title;
    private String description;
    private int ticketStatusId;
    private String ticketStatusLabel;
    private Instant creationDate;
    private Integer createdBy;
    private Instant lastUpdateDate;
    private Integer lastUpdatedBy;

    public TicketDTO() {
    }

    public TicketDTO(Long id, String ticketNumber, String title, String description, TicketStatus ticketStatus, Instant creationDate, Integer createdBy, Instant lastUpdateDate, Integer lastUpdatedBy) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.ticketStatusId = ticketStatus.getId();
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public TicketDTO(Ticket entity) {
        id = entity.getId();
        ticketNumber = entity.getTicketNumber();
        title = entity.getTitle();
        description = entity.getDescription();
        ticketStatusId = entity.getTicketStatus().getId();
        ticketStatusLabel = entity.getTicketStatus().getLabel();
        creationDate = entity.getCreationDate();
        createdBy = entity.getCreatedBy();
        lastUpdateDate = entity.getLastUpdateDate();
        lastUpdatedBy = entity.getLastUpdatedBy();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTicketStatusId() {
        return ticketStatusId;
    }

    public void setTicketStatusId(int ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }

    public String getTicketStatusLabel() {
        return ticketStatusLabel;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

