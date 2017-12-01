package models;

public class OriginalDeck extends Deck {

    public OriginalDeck() {

        for(int i = 2; i < 15; i++){
            cards.add(new Card(i, Suit.Clubs));
            cards.add(new Card(i, Suit.Hearts));
            cards.add(new Card(i, Suit.Diamonds));
            cards.add(new Card(i, Suit.Spades));
        }

        originalSize = 52;
    }
}
