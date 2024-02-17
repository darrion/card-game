package io.darrion.acmecardgame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.darrion.acmecardgame.exception.EmptyDeckException;
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
        isNotEmpty();
        return this.cards.remove(0);
    }

    @JsonIgnore
    public synchronized Card getBottomCard() {
        isNotEmpty();
        return this.cards.remove(this.cards.size() - 1);
    }

    public synchronized void isNotEmpty() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException(String.format("The deck %s is empty.", this.id));
        }
    }
}