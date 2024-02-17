package io.darrion.acmecardgame.response;

import io.darrion.acmecardgame.model.Deck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Component
public class DeckResponse {

    private String id;
    private List<CardResponse> cards;

    public DeckResponse(Deck deck) {
        this.id = deck.getId();
        this.cards = deck.getCards()
                .stream()
                .map(CardResponse::new)
                .collect(Collectors.toList());
    }
}
