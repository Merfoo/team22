package models;

import java.util.ArrayList;

public class OriginalGame extends Game {

    public OriginalGame(){
        super();
        deck = new OriginalDeck();
        deck.shuffle();

        for(int i = 0; i < 4; i++)
            cardColumns.add(new CardColumn());
    }

    private boolean canRemoveTopCard(int column){
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
    @Override
    protected void updateColumns() {
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
}
