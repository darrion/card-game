package io.darrion.acmecardgame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@NoArgsConstructor
@Getter
@Setter
@Component
public class Deck {

    private String id;
    private CopyOnWriteArrayList<Card> cards;

    public Deck(String id, List<Card> cards) {
        this.id = id;
        this.cards = new CopyOnWriteArrayList<>(cards);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    @JsonIgnore
    public synchronized Card getTopCard() {
        if (this.cards.isEmpty()) {
            return null;
        }
        return this.cards.remove(0);
    }

    @JsonIgnore
    public synchronized Card getBottomCard() {
        if (this.cards.isEmpty()) {
            return null;
        }
        return this.cards.remove(this.cards.size() - 1);
    }
}