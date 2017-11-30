package models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.ArrayList;

@JsonTypeInfo(use = Id.CLASS,
                include = JsonTypeInfo.As.PROPERTY,
                property = "type")
@JsonSubTypes({
        @Type(value = OriginalGame.class)
})
public abstract class Game {

    public Deck deck = null;
    public java.util.List<CardColumn> cardColumns = new ArrayList<>();
    public int score = 0;
    public boolean gameEnded = false;

    /*
        Removes the top card from a column
    */
    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if (columnHasCards(columnNumber)) {
            removeCardFromCol(columnNumber);

            updateColumns();
            updateScore();
            updateGameEnded();
        }
    }

    /*
        Moves a card from one column to another
    */
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);

            updateColumns();
            updateGameEnded();
        }
    }

    /*
        Deals 1 card to each column if it can, e.g the deck has cards
    */
    public void dealFour() {
        for (int i = 0; i < 4; i++) {
            if(deck.hasCards()) {
                // This is Fauzi's doing
                Card topDog = deck.getTopCard();
                addCardToCol(i, topDog);
            }

            else
                break;
        }

        updateColumns();
        updateGameEnded();
    }

    /*
        Calculates the current score of the game and updates the score member variable
    */
    protected void updateScore(){
        //final score is equal to beginning card count - number of cards remaining in deck - number of cards remaining in each of the four columns
        int numCardsInCols = 0;
        int beginningCardCount = deck.originalSize();

        //sums number of remaining cards in each column
        for(int i = 0; i < 4; i++){
            numCardsInCols = numCardsInCols + cardColumns.get(i).cards.size();
        }

        score = beginningCardCount - deck.size() - numCardsInCols;
    }

    /*
        Checks if the column has cards, true if it does, false otherwise
    */
    protected boolean columnHasCards(int columnNumber) {
        return cardColumns.get(columnNumber).hasCards();
    }

    /*
        Gets the top card from a column
    */
    protected Card getTopCard(int columnNumber) {
        return cardColumns.get(columnNumber).getTop();
    }

    /*
        Adds a the passed in card to the column
    */
    protected void addCardToCol(int columnTo, Card cardToMove) {
        cardColumns.get(columnTo).add(cardToMove);
    }

    /*
        Removes the top card from a column
    */
    protected void removeCardFromCol(int colFrom) {
        cardColumns.get(colFrom).removeTop();
    }

    /*
        This checks if the game has ended by checking if the deck size is 0
        and the user can make any moves or removes
    */
    protected abstract void updateGameEnded();

    /*
        Update cardColumn element with canRemove and canMove member variables
        Called every time game state is updated
    */
    protected abstract void updateColumns();
}
