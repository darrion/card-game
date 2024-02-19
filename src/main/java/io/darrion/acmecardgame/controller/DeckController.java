package io.darrion.acmecardgame.controller;

import io.darrion.acmecardgame.exception.DeckDoesNotExistException;
import io.darrion.acmecardgame.exception.EmptyDeckException;
import io.darrion.acmecardgame.model.Card;
import io.darrion.acmecardgame.response.CardResponse;
import io.darrion.acmecardgame.model.Deck;

import io.darrion.acmecardgame.response.DeckResponse;
import io.darrion.acmecardgame.response.ErrorResponse;
import io.darrion.acmecardgame.service.Dealer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    public Dealer dealer;

    @GetMapping("/get")
    public DeckResponse getDeck() {
        Deck deck = dealer.getDeck();
        return new DeckResponse(deck);
    }

    @GetMapping("/top/{gameId}")
    public ResponseEntity<Object> getTopCard(@PathVariable String gameId) {
        try {
            Card card = dealer.getTopCard(gameId);
            CardResponse cardResponse = new CardResponse(card);
            return ResponseEntity.ok(cardResponse);
        } catch (EmptyDeckException | DeckDoesNotExistException ex) {
            return getErrorResponseEntity(ex);
        }

    }

    @GetMapping("/bottom/{gameId}")
    public ResponseEntity<Object> getBottomCard(@PathVariable String gameId) {
        try {
            Card card = dealer.getBottomCard(gameId);
            CardResponse cardResponse = new CardResponse(card);
            return ResponseEntity.ok(cardResponse);
        } catch (EmptyDeckException | DeckDoesNotExistException ex) {
            return getErrorResponseEntity(ex);
        }
    }

    @PutMapping("/shuffle/{gameId}")
    public ResponseEntity<Object> shuffle(@PathVariable String gameId) {
        try {
            dealer.shuffle(gameId);
            Deck deck = dealer.getDeck(gameId);
            DeckResponse deckResponse = new DeckResponse(deck);
            return ResponseEntity.ok(deckResponse);
        } catch (EmptyDeckException | DeckDoesNotExistException ex) {
            return getErrorResponseEntity(ex);
        }
    }

    private ResponseEntity<Object> getErrorResponseEntity(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }
}

