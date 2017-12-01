package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testOriginalCardColumn {

    @Test
    public void testCardArray(){
        OriginalCardColumn c = new OriginalCardColumn();
        assertNotNull(c.cards);
    }

    @Test
    public void testAddCards(){
        OriginalCardColumn c = new OriginalCardColumn();
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        assertEquals(1, c.cards.size());
    }

    @Test
    public void testgetTop(){
        OriginalCardColumn c = new OriginalCardColumn();
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        assertEquals(card, c.getTop());
    }

    @Test
    public void testRemoveCards(){
        OriginalCardColumn c = new OriginalCardColumn();
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        c.removeTop();
        assertEquals(0, c.cards.size());
    }

    @Test
    public void testHasCards(){
        OriginalCardColumn c = new OriginalCardColumn();
        assertEquals(false, c.hasCards());
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        assertEquals(true, c.hasCards());
    }
}
