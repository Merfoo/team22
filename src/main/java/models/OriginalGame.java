package models;

import java.util.ArrayList;

public class OriginalGame extends Game {

    public OriginalGame(){
        super();
        deck = new Deck();

        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++){
            cardColumns.add(new CardColumn());
        }
        deck.shuffle();
    }
}
