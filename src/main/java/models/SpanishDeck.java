package models;

public class SpanishDeck extends Deck {

    public SpanishDeck() {

        for(int i = 2; i < 14; i++){
            cards.add(new Card(i, Suit.Bastos));
            cards.add(new Card(i, Suit.Oros));
            cards.add(new Card(i, Suit.Copas));
            cards.add(new Card(i, Suit.Espadas));
        }

        for (int i = 0; i < 2; i++){
            cards.add(new Card(14, Suit.Comodines));
        }

        originalSize = 50;
    }
}
