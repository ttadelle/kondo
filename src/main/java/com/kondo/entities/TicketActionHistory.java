package com.kondo.entities;

import com.kondo.entities.enums.TicketStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_ticket_action_history")
public class TicketActionHistory extends CreateAndUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticket_status_id")
    private TicketStatus ticketStatus;

    /*@ManyToOne
    @JoinColumn(name = "ticket_id")*/
    private Long ticketId;

    public TicketActionHistory() {
    }

    public TicketActionHistory(Instant creationDate, Integer createdBy, Instant lastUpdateDate, Integer lastUpdatedBy, Long id, String description, TicketStatus ticketStatus, Long ticketId) {
        super(creationDate, createdBy, lastUpdateDate, lastUpdatedBy);
        this.id = id;
        this.description = description;
        this.ticketStatus = ticketStatus;
        this.ticketId = ticketId;
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

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketActionHistory that = (TicketActionHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
