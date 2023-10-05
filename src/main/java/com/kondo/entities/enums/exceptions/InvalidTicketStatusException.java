package com.kondo.entities.enums.exceptions;

public class InvalidTicketStatusException extends RuntimeException{

    public InvalidTicketStatusException(String msg) {
        super(msg);
    }
}
