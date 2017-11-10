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
        if (columnHasCards(columnNumber) && canRemove(columnNumber)) {
            cardColumns.get(columnNumber).removeTop();
        }
        updateColumnState();
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
        updateColumnState();
    }

    public void dealFour() {
        for (int i = 0; i < 4; i++) {
            if(deck.hasCards()) {
                // This is Fauzi's doing
                Card topDog = deck.getTopCard();
                cardColumns.get(i).add(topDog);
            }
            else
                break;
        }
        updateColumnState();
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cardColumns.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        cardColumns.get(colFrom).removeTop();
    }
    
    private boolean canRemove(int column){
        boolean canRemove = false;
        for (int i = 0; i < 4; i++){
            if (i != column){
                if (cardColumns.get(i).getTop().getSuit() == cardColumns.get(column).getTop().getSuit()){
                    canRemove = true;
                }
            }
        }
        return canRemove;
    }

    private boolean canMove(int column){
        return true;
    }

    // Update cardColumn element with canRemove and canMove member variables
    // Called every time game state is updated
    private void updateColumnState(){
        for (int i = 0; i < 4; i++){
            if (canRemove(i)){
                cardColumns.get(i).canRemove = true;
            }
            else
                cardColumns.get(i).canRemove = false;
            if (canMove(i)){
                cardColumns.get(i).canMove = true;
            }
            else
                cardColumns.get(i).canMove = false;
        }
    }
}
