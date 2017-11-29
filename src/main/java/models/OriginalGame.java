package models;

import java.util.ArrayList;

public class OriginalGame extends Game {

    public OriginalGame(){
        super();
        deck = new Deck();
        deck.shuffle();
    }
}
