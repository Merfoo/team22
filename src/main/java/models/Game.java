package models;

import java.util.ArrayList;

public class Game {

    public Deck deck = new Deck();
    public java.util.List<CardColumn> cardColumns = new ArrayList<>();

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++){
            cardColumns.add(new CardColumn());
        }

        deck.shuffle();
    }


    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if (columnHasCards(columnNumber)) {
            cardColumns.get(columnNumber).removeTop();
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return cardColumns.get(columnNumber).hasCards();
    }

    private Card getTopCard(int columnNumber) {
        return cardColumns.get(columnNumber).getTop();
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++) {
            if(deck.hasCards()) {
                // This is Fauzi's doing
                Card topDog = deck.getTopCard();
                cardColumns.get(i).add(topDog);
            }

            else
                break;
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cardColumns.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        cardColumns.get(colFrom).removeTop();
    }
}
