package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testOriginalGame {

    @Test
    public void testGameCreation(){
        OriginalGame g = new  OriginalGame();
        assertNotNull(g);
    }

    @Test
    public void testBuildDeck(){
        OriginalGame g =  new  OriginalGame();
        assertEquals(52,g.deck.cards.size());
    }

    @Test
    public void testCardColumnCreation(){
        OriginalGame g = new  OriginalGame();
        assertEquals(4, g.cardColumns.size());
    }

    @Test
    public void testGameShuffle(){
        OriginalGame g1 = new  OriginalGame();
        g1.deck.shuffle();
        OriginalGame g2 = new  OriginalGame();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testRemoveFunction(){
        OriginalGame g = new  OriginalGame();
        g.dealFour();
        g.remove(0);
        assertEquals(0, g.cardColumns.get(0).cards.size());
    }

    @Test
    public void testMove(){
        OriginalGame g = new  OriginalGame();
        g.dealFour();
        g.move(0, 1);
        assertEquals(2, g.cardColumns.get(1).cards.size());
        assertEquals(0, g.cardColumns.get(0).cards.size());
    }

    @Test
    public void testUpdateScore(){
        OriginalGame g = new  OriginalGame();
        assertEquals(0, g.score);
        g.dealFour();
        g.remove(0);
        assertEquals(1, g.score);
    }

    @Test
    public void testGameEnded(){
        OriginalGame g = new  OriginalGame();
        OriginalDeck d = new OriginalDeck();
        assertEquals(false, g.gameEnded);

    }
}
