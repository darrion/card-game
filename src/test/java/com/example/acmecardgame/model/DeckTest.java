package com.example.acmecardgame.model;

import com.example.acmecardgame.exception.EmptyDeckException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DeckTest {

    @Mock
    CopyOnWriteArrayList<Card> cards;

    @InjectMocks
    Deck deck;

    @BeforeEach
    void before() {
        deck.setCards(new CopyOnWriteArrayList<>());
    }

    @Test
    void testGetTopCardOnEmptyDeck() {
        // If the deck is empty, assert that empty deck exception is thrown.
        assertThrows(EmptyDeckException.class, () -> deck.getTopCard());
    }

    @Test
    void testGetBottomCardOnEmptyDeck() {
        // If the deck is empty, assert that empty deck exception is thrown.
        assertThrows(EmptyDeckException.class, () -> deck.getBottomCard());
    }

    @Test
    void testSafeOnEmptyDeck() {
        // If the deck is empty, assert that empty deck exception is thrown.
        assertThrows(EmptyDeckException.class, () -> deck.safe());
    }

    @Test
    public void testConcurrentAccessToDeck() throws InterruptedException {
        // Author: ChatGPT
        // Create a deck with some cards
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(new Suit("SPADE"), new Rank("TWO")));
        cards.add(new Card(new Suit("HEART"), new Rank("THREE")));
        Deck deck = new Deck("testDeck", cards);

        // Create a latch to synchronize the start of all threads
        int numThreads = 10; // Number of concurrent threads
        CountDownLatch latch = new CountDownLatch(numThreads);

        // Create an executor service to manage the threads
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Create and submit tasks to the executor service
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                // Wait until all threads are ready to start
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                // Each thread tries to get a card from the top and bottom of the deck
                assertDoesNotThrow(() -> {
                    Card topCard = deck.getTopCard();
                    Card bottomCard = deck.getBottomCard();
                    // Process topCard and bottomCard as needed
                });
            });
            // Countdown the latch to indicate that the thread is ready to start
            latch.countDown();
        }

        // Shutdown the executor service and wait for all threads to finish
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }



}
