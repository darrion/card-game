package io.darrion.acmecardgame.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
@AllArgsConstructor
@Component
public class Card {
    private Suit suit;
    private Rank rank;
}
