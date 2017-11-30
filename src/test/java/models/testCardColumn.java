package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testCardColumn {

    @Test
    public void testCardArray(){
        CardColumn c = new CardColumn();
        assertNotNull(c.cards);
    }

    @Test
    public void testAddCards(){
        CardColumn c = new CardColumn();
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        assertEquals(1, c.cards.size());
    }

    @Test
    public void testgetTop(){
        CardColumn c = new CardColumn();
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        assertEquals(card, c.getTop());
    }

    @Test
    public void testRemoveCards(){
        CardColumn c = new CardColumn();
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        c.removeTop();
        assertEquals(0, c.cards.size());
    }

    @Test
    public void testHasCards(){
        CardColumn c = new CardColumn();
        assertEquals(false, c.hasCards());
        Card card = new Card(5, Suit.Clubs);
        c.add(card);
        assertEquals(true, c.hasCards());
    }


}
