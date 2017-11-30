package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5, Suit.Clubs);
        assertEquals(Suit.Clubs, c.getSuit());
    }

    @Test
    public void testGetValue(){
        Card c = new Card(5, Suit.Clubs);
        assertEquals(5, c.getValue());
    }

    @Test
    public void testToString() {
        Card c1 = new Card(5, Suit.Clubs);
        assertEquals("5 Clubs", c1.toString());
        Card c2 = new Card(11, Suit.Hearts);
        assertEquals("J Hearts", c2.toString());
        Card c3 = new Card(12, Suit.Spades);
        assertEquals("Q Spades", c3.toString());
        Card c4 = new Card(13, Suit.Diamonds);
        assertEquals("K Diamonds", c4.toString());
        Card c5 = new Card(14, Suit.Diamonds);
        assertEquals("A Diamonds", c5.toString());
    }





}
