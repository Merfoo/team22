package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++){
            cols.add(i, new ArrayList<Card>());
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if (columnHasCards(columnNumber)) {
            removeCardFromCol(columnNumber);
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        int columnSize = this.cols.get(columnNumber).size();
        if (columnSize != 0)
          return true;
        else
          return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
