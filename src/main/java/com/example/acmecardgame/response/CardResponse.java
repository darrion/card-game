package com.example.acmecardgame.response;


import com.example.acmecardgame.model.Card;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
public class CardResponse {
    private String suit;
    private String rank;

    public CardResponse(Card card) {
        this.suit = card.getSuit().getType();
        this.rank = card.getRank().getType();
    }
}
