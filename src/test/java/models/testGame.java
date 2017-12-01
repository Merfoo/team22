package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new  Game();
        assertNotNull(g);
    }

    @Test
    public void testBuildDeck(){
        Game g =  new  Game();
        assertEquals(52,g.deck.cards.size());
    }

    @Test
    public void testCardColumnCreation(){
        Game g = new  Game();
        assertEquals(4, g.cardColumns.size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new  Game();
        g1.deck.shuffle();
        Game g2 = new  Game();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testRemoveFunction(){
        Game g = new  Game();
        g.dealFour();
        g.remove(0);
        assertEquals(0, g.cardColumns.get(0).cards.size());
    }

    @Test
    public void testMove(){
        Game g = new  Game();
        g.dealFour();
        g.move(0, 1);
        assertEquals(2, g.cardColumns.get(1).cards.size());
        assertEquals(0, g.cardColumns.get(0).cards.size());
    }

    @Test
    public void testUpdateScore(){
        Game g = new  Game();
        assertEquals(0, g.score);
        g.dealFour();
        g.remove(0);
        assertEquals(1, g.score);
    }

}
