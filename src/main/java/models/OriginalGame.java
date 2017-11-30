package models;

public class OriginalGame extends Game {

    public OriginalGame(){
        super();
        deck = new OriginalDeck();
        deck.shuffle();
    }
}
