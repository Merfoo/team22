package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {

    @Test
    public void testColumnCreation(){
        java.util.List<CardColumn> cardColumns = new ArrayList<>()
        cardColumns.add(new CardColumn());
        assertEquals(1, cardColumns.size());
    }

    @Test
    public void testAddCards(){

    }

    @Test
    public void testRemoveCards(){

    }

    @Test
    public void testHasCards(){

    }


}
