package io.darrion.acmecardgame;

import io.darrion.acmecardgame.controller.DeckController;
import io.darrion.acmecardgame.service.Dealer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class AcmeCardInstructionApplicationTests {

    @Autowired
    DeckController deckController;

    @Autowired
    Dealer dealer;

    @Test
    void contextLoads() {
        assertNotNull(deckController);
        assertNotNull(dealer);
    }
}
