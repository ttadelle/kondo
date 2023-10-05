package com.kondo.entities.enums;

import com.kondo.entities.enums.exceptions.InvalidTicketStatusException;

public enum TicketStatus {

    OPEN(0,"Aberto"),
    IN_PROGRESS(1,"Em atendimento"),
    SOLVED(2,"Resolvido"),
    CLOSED(3,"Encerrado"),
    REOPENED(4,"Reaberto"),
    SCHEDULED(5,"Agendado"),
    RETURNED(6,"Devolvido"),
    CANCELLED(7,"Cancelado");

    private final int id;
    private final String label;

    TicketStatus(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TicketStatus fromValue(int value) {
        for (TicketStatus status : TicketStatus.values()) {
            if (status.getId() == value) {
                return status;
            }
        }
        throw new InvalidTicketStatusException("Valor int não corresponde a nenhum TicketStatus: " + value);
    }
}
