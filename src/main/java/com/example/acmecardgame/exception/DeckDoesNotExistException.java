package com.example.acmecardgame.exception;

public class DeckDoesNotExistException extends RuntimeException {
    public DeckDoesNotExistException(String message) {
        super(message);
    }
}
