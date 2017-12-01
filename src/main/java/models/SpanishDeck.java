package models;

public class SpanishDeck extends Deck {

    public SpanishDeck() {
        for(int i = 1; i < 13; i++){
            cards.add(new Card(i, Suit.Bastos));
            cards.add(new Card(i, Suit.Oros));
            cards.add(new Card(i, Suit.Copas));
            cards.add(new Card(i, Suit.Espadas));
        }

        for (int i = 0; i < 2; i++){
            cards.add(new Card(13, Suit.Comodines));
        }

        originalSize = 50;
    }
}
