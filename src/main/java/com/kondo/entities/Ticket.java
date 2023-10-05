package com.kondo.entities;

import com.kondo.entities.enums.TicketStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_ticket")
public class Ticket extends CreateAndUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketNumber;
    private String title;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticket_status_id")
    private TicketStatus ticketStatus;

/*    @OneToMany(mappedBy = "ticket")
    private List<TicketActionHistory> actions; */

    public Ticket() {
    }

    public Ticket(Instant creationDate, Integer createdBy, Instant lastUpdateDate, Integer lastUpdatedBy, Long id, String ticketNumber, String title, String description, TicketStatus ticketStatus) {
        super(creationDate, createdBy, lastUpdateDate, lastUpdatedBy);
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.ticketStatus = ticketStatus;
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

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
