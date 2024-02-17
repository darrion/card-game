package io.darrion.acmecardgame.factory;

import io.darrion.acmecardgame.config.RankConfig;
import io.darrion.acmecardgame.config.SuitConfig;
import io.darrion.acmecardgame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class DeckFactory {

    @Autowired
    RankConfig rankConfig;
    @Autowired
    SuitConfig suitConfig;

    public Deck create() {
        CopyOnWriteArrayList<Card> cards = new CopyOnWriteArrayList<>();
        List<Rank> ranks = rankConfig.getRanks();
        List<Suit> suits = suitConfig.getSuits();

        suits.forEach(suit -> {
            ranks.forEach(rank -> {
                Card card = new Card(suit, rank);
                cards.add(card);
            });
        });

        String uniqueId = UUID.randomUUID().toString();

        return new Deck(uniqueId, cards);
    }
}
