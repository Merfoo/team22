package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testSpanishDeck {

    @Test
    public void testDeckSize(){
        SpanishDeck d = new SpanishDeck();
        assertEquals(50, d.cards.size());
    }
}
