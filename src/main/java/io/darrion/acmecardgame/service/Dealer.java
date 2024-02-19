package io.darrion.acmecardgame.service;

import io.darrion.acmecardgame.exception.DeckDoesNotExistException;
import io.darrion.acmecardgame.exception.EmptyDeckException;
import io.darrion.acmecardgame.factory.DeckFactory;
import io.darrion.acmecardgame.model.Card;
import io.darrion.acmecardgame.model.Deck;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class Dealer {

    @Autowired
    public DeckFactory deckFactory;

    @Autowired
    public Map<String, Deck> decks;

    public Dealer() {}

    public Deck getDeck() {
        Deck deck = deckFactory.create();
        decks.put(deck.getId(), deck);
        return deck;
    }

    public Deck getDeck(String id) {
        Deck deck = this.decks.get(id);
        if (deck == null) {
            throwDeckDoesNotExistException(id);
        }
        return deck;
    }

    public Card getTopCard(String id) {
        Deck deck = this.getDeck(id);
        return deck.getTopCard();
    }

    public Card getBottomCard(String id) {
        Deck deck = this.getDeck(id);
        return deck.getBottomCard();
    }

    public void shuffle(String id) {
        this.getDeck(id).shuffle();
    }

    private void throwDeckDoesNotExistException(String id) {
        throw new DeckDoesNotExistException(String.format("The deck %s does not exist.", id));
    }
}
