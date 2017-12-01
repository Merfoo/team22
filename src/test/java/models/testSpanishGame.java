package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testSpanishGame {

    @Test
    public void testGameCreation(){
        SpanishGame g = new  SpanishGame();
        assertNotNull(g);
    }

    @Test
    public void testBuildDeck(){
        SpanishGame g =  new  SpanishGame();
        assertEquals(50,g.deck.cards.size());
    }

    @Test
    public void testCardColumnCreation(){
        SpanishGame g = new  SpanishGame();
        assertEquals(4, g.cardColumns.size());
    }

    @Test
    public void testGameShuffle(){
        SpanishGame g1 = new  SpanishGame();
        g1.deck.shuffle();
        SpanishGame g2 = new  SpanishGame();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testRemoveFunction(){
        SpanishGame g = new  SpanishGame();
        g.dealFour();
        g.remove(0);
        assertEquals(0, g.cardColumns.get(0).cards.size());
    }

    @Test
    public void testMove(){
        SpanishGame g = new  SpanishGame();
        g.dealFour();
        g.move(0, 1);
        assertEquals(2, g.cardColumns.get(1).cards.size());
        assertEquals(0, g.cardColumns.get(0).cards.size());
    }

    @Test
    public void testUpdateScore(){
        SpanishGame g = new  SpanishGame();
        assertEquals(0, g.score);
        g.dealFour();
        g.remove(0);
        assertEquals(1, g.score);
    }
}
