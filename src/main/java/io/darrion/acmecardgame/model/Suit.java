package io.darrion.acmecardgame.model;

import org.springframework.stereotype.Component;

@Component
public class Suit {
    private String type;

    public Suit() {}

    public Suit(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
