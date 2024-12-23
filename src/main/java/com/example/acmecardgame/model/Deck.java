package com.example.acmecardgame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.acmecardgame.exception.EmptyDeckException;
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

    public synchronized void shuffle() {
        Collections.shuffle(this.cards);
    }

    @JsonIgnore
    public synchronized Card getTopCard() {
        safe();
        return this.cards.remove(0);
    }

    @JsonIgnore
    public synchronized Card getBottomCard() {
        safe();
        return this.cards.remove(this.cards.size() - 1);
    }

    public synchronized void safe() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException(String.format("The deck %s is empty.", this.id));
        }
    }


}