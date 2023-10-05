package com.kondo.DTO;

import com.kondo.entities.TicketActionHistory;
import com.kondo.entities.enums.TicketStatus;

import java.time.Instant;
import java.util.Objects;

public class TicketActionHistoryDTO {

    private Long id;
    private String description;
    private int ticketStatusId;
    private String ticketStatusLabel;
    private Instant creationDate;
    private Integer createdBy;
    private Instant lastUpdateDate;
    private Integer lastUpdatedBy;
    private Long ticketId;

    public TicketActionHistoryDTO(Long id, String description, TicketStatus ticketStatus, Instant creationDate, Integer createdBy, Instant lastUpdateDate, Integer lastUpdatedBy, Long ticketId) {
        this.id = id;
        this.description = description;
        this.ticketStatusId = ticketStatus.getId();
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ticketId = ticketId;
    }

    public TicketActionHistoryDTO(TicketActionHistory entity) {
        creationDate = entity.getCreationDate();
        createdBy = entity.getCreatedBy();
        lastUpdateDate = entity.getLastUpdateDate();
        lastUpdatedBy = entity.getLastUpdatedBy();
        id = entity.getId();
        description = entity.getDescription();
        ticketStatusId = entity.getTicketStatus().getId();
        ticketStatusLabel = entity.getTicketStatus().getLabel();
        ticketId = entity.getTicketId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticket) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketActionHistoryDTO that = (TicketActionHistoryDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
