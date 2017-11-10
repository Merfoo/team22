package models;

import java.util.ArrayList;

public class Game {

    public Deck deck = new Deck();
    public java.util.List<CardColumn> cardColumns = new ArrayList<>();
    public int score = 0;

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++){
            cardColumns.add(new CardColumn());
        }
        deck.shuffle();
    }

    public int getScore(){return score;}

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if (columnHasCards(columnNumber) && cardColumns.get(columnNumber).canRemoveTopCard) {
            cardColumns.get(columnNumber).removeTop();
        }
        updateColumnState();
        calculateScore();
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
        calculateScore();
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cardColumns.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        cardColumns.get(colFrom).removeTop();
    }

    private boolean canRemoveTopCard(int column){
        boolean canRemove = false;

        // If the top card is an Ace then we can't remove it
        if(cardColumns.get(column).hasCards())
            if(cardColumns.get(column).getTop().getValue() == 14)
                return false;

        for (int i = 0; i < 4; i++){
            if (i != column && cardColumns.get(i).hasCards() && cardColumns.get(column).hasCards()){
                if (cardColumns.get(i).getTop().getSuit() == cardColumns.get(column).getTop().getSuit()){
                    canRemove = true;
                }
            }
        }

        return canRemove;
    }

    // Update cardColumn element with canRemove and canMove member variables
    // Called every time game state is updated
    private void updateColumnState() {
        java.util.List<Integer> columnsWithAces = new ArrayList<>();
        boolean emptyColumnExists = false;

        for (int i = 0; i < 4; i++) {
            cardColumns.get(i).canRemoveTopCard = canRemoveTopCard(i);
            cardColumns.get(i).canMoveAce = false;

            // Check if the top card is an Ace, if so, add the index to columnsWithAces
            if(cardColumns.get(i).hasCards()){
                if(cardColumns.get(i).getTop().getValue() == 14)
                    columnsWithAces.add(i);
            }

            // Else the column is empty
            else
                emptyColumnExists = true;
        }

        // If an empty column exists, set all columns with an ace as the top
        // card canMoveAce variable to true
        if(emptyColumnExists){
            for(int i = 0; i < columnsWithAces.size(); i++) {
                cardColumns.get(columnsWithAces.get(i)).canMoveAce = true;
            }
        }
    }
      
    public void calculateScore(){
        //final score is equal to beginning card count - number of cards remaining in deck - number of cards remaining in each of the four columns
        int numCardsinCols = 0;
        int beginningCardCount = 52;
        //sums number of remaining cards in each column
        for(int i = 0; i < 4; i++){
            numCardsinCols = numCardsinCols + cardColumns.get(i).cards.size();
        }
        score = beginningCardCount - deck.size()- numCardsinCols;
    }
}
