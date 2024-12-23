package com.example.acmecardgame;

import com.example.acmecardgame.controller.DeckController;
import com.example.acmecardgame.service.Dealer;
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
