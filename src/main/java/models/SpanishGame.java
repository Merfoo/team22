package models;

import java.util.ArrayList;

public class SpanishGame extends Game {

    public SpanishGame(){
        deck = new SpanishDeck();
        deck.shuffle();

        for(int i = 0; i < 4; i++){
            cardColumns.add(new SpanishCardColumn());
        }
    }

    private boolean canRemoveTopCard(int column){
        boolean canRemove = false;

        for (int i = 0; i < 4; i++){
            if (i != column && columnHasCards(i) && columnHasCards(column)){
                if (getTopCard(i).getSuit() == getTopCard(column).getSuit() &&
                        getTopCard(i).getValue() > getTopCard(column).getValue() ||
                        getTopCard(i).getSuit() == Suit.Comodines){
                    canRemove = true;
                }
            }
        }

        return canRemove;
    }

    // This checks if the game has ended by checking if the deck size is 0
    // and the user can make any moves or removes
    @Override
    protected void updateGameEnded() {
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
            }

            // If there are moves available, then the game has NOT ended
            gameEnded = !movesAvailable;
        }
    }

    // Update cardColumn element with canRemove and canMove member variables
    // Called every time game state is updated
    @Override
    protected void updateColumns() {
        for (int i = 0; i < 4; i++) {
            cardColumns.get(i).canRemoveTopCard = canRemoveTopCard(i);
        }
    }
}
