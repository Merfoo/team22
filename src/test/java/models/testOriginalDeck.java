package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testOriginalDeck {

    @Test
    public void testDeckCreation(){
        OriginalDeck d = new OriginalDeck();
        assertNotNull(d.cards);
    }

    @Test
    public void testHasCards(){
        OriginalDeck d = new OriginalDeck();
        assertEquals(true, d.hasCards());
    }

    @Test
    public void testDeckSize(){
        OriginalDeck d = new OriginalDeck();
        assertEquals(52, d.cards.size());
    }

}
