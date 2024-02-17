package io.darrion.acmecardgame.service;

import io.darrion.acmecardgame.factory.DeckFactory;
import io.darrion.acmecardgame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Dealer {

    @Autowired
    public DeckFactory deckFactory;

    @Autowired
    public Map<String, Deck> decks;

    public Deck getDeck() {
        Deck deck = deckFactory.create();
        decks.put(deck.getId(), deck);
        return deck;
    }

    public Deck getDeck(String gameId) {
        return decks.get(gameId);
    }

    public Card getTopCard(String id) {
        return decks.get(id).getTopCard();
    }

    public Card getBottomCard(String id) {
        return decks.get(id).getBottomCard();
    }

    public void shuffle(String id) {
        decks.get(id).shuffle();
    }
}
