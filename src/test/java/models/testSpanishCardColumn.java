package models;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testSpanishCardColumn {

    @Test
    public void testCardArray(){
        SpanishCardColumn c = new SpanishCardColumn();
        assertNotNull(c.cards);
    }
}
