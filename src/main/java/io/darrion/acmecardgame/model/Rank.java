package io.darrion.acmecardgame.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Rank {
    @Getter @Setter
    private String type;

    public Rank() {}
}
