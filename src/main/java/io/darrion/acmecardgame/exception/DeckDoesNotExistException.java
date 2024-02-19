package io.darrion.acmecardgame.exception;

public class DeckDoesNotExistException extends RuntimeException {
    public DeckDoesNotExistException(String message) {
        super(message);
    }
}
