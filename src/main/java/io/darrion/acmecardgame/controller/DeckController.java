package io.darrion.acmecardgame.controller;

import io.darrion.acmecardgame.exception.EmptyDeckException;
import io.darrion.acmecardgame.model.Card;
import io.darrion.acmecardgame.response.CardResponse;
import io.darrion.acmecardgame.model.Deck;

import io.darrion.acmecardgame.response.DeckResponse;
import io.darrion.acmecardgame.response.ErrorResponse;
import io.darrion.acmecardgame.service.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/v1")
public class DeckController {

    @Autowired
    public Dealer dealer;

    @GetMapping("/deck/get")
    public DeckResponse getDeck() {
        Deck deck = dealer.getDeck();
        return new DeckResponse(deck);
    }

    @GetMapping("/deal/top/{gameId}")
    public ResponseEntity<Object> getTopCard(@PathVariable String gameId) {
        try {
            Card card = dealer.getTopCard(gameId);
            CardResponse cardResponse = new CardResponse(card);
            return ResponseEntity.ok(cardResponse);
        } catch (EmptyDeckException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
        }

    }

    @GetMapping("/deal/bottom/{gameId}")
    public CardResponse getBottomCard(@PathVariable String gameId) {
        Card card = dealer.getBottomCard(gameId);
        return new CardResponse(card);
    }

    @PutMapping("/deal/shuffle/{gameId}")
    public DeckResponse shuffle(@PathVariable String gameId) {
        dealer.shuffle(gameId);
        Deck deck = dealer.getDeck(gameId);
        return new DeckResponse(deck);
    }
}

