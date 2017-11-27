package models;

import java.util.ArrayList;

public class Game {

    public Deck deck;
    public java.util.List<CardColumn> cardColumns = new ArrayList<>();
    public int score = 0;
    public boolean gameEnded = false;

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++){
            cardColumns.add(new CardColumn());
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if (columnHasCards(columnNumber) && cardColumns.get(columnNumber).canRemoveTopCard) {
            cardColumns.get(columnNumber).removeTop();
        }

        updateColumnState();
        calculateScore();
        checkEndGame();
    }

    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }

        updateColumnState();
        checkEndGame();
    }

    protected boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return cardColumns.get(columnNumber).hasCards();
    }

    protected Card getTopCard(int columnNumber) {
        return cardColumns.get(columnNumber).getTop();
    }

    protected void addCardToCol(int columnTo, Card cardToMove) {
        cardColumns.get(columnTo).add(cardToMove);
    }

    protected void removeCardFromCol(int colFrom) {
        cardColumns.get(colFrom).removeTop();
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
        checkEndGame();
    }

    protected boolean canRemoveTopCard(int column){
        boolean canRemove = false;

        // If the top card is an Ace then we can't remove it
        if(cardColumns.get(column).hasCards())
            if(cardColumns.get(column).getTop().getValue() == 14)
                return false;

        for (int i = 0; i < 4; i++){
            if (i != column && cardColumns.get(i).hasCards() && cardColumns.get(column).hasCards()){
                if (cardColumns.get(i).getTop().getSuit() == cardColumns.get(column).getTop().getSuit() &&
                    cardColumns.get(i).getTop().getValue() > cardColumns.get(column).getTop().getValue()){
                    canRemove = true;
                }
            }
        }

        return canRemove;
    }

    // This checks if the game has ended by checking if the deck size is 0
    // and the user can make any moves or removes
    protected void checkEndGame() {
        gameEnded = false;

        if (deck.size() == 0){
            boolean movesAvailable = false;

            // Loops through each column checking if a card can be removed/moved
            // if so, then there are moves available to the user
            for (int i = 0; i < cardColumns.size(); i++) {
                if (cardColumns.get(i).canRemoveTopCard) {
                    movesAvailable = true;
                    break;
                }

                if (cardColumns.get(i).canMoveAce) {
                    movesAvailable = true;
                    break;
                }
            }

            // If there are moves available, then the game has NOT ended
            gameEnded = !movesAvailable;
        }
    }

    // Update cardColumn element with canRemove and canMove member variables
    // Called every time game state is updated
    protected void updateColumnState() {
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
      
    protected void calculateScore(){
        //final score is equal to beginning card count - number of cards remaining in deck - number of cards remaining in each of the four columns
        int numCardsInCols = 0;
        int beginningCardCount = 52;
        //sums number of remaining cards in each column
        for(int i = 0; i < 4; i++){
            numCardsInCols = numCardsInCols + cardColumns.get(i).cards.size();
        }
        score = beginningCardCount - deck.size()- numCardsInCols;
    }
}
