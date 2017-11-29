package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{

    public java.util.List<Card> cards = new ArrayList<Card>(52);

    public Deck() {
//        for(int i = 2; i < 15; i++){
//            cards.add(new Card(i, Suit.Clubs));
//            cards.add(new Card(i, Suit.Hearts));
//            cards.add(new Card(i, Suit.Diamonds));
//            cards.add(new Card(i, Suit.Spades));
//        }
    }

    public void shuffle() {
        // shuffles the cards so that it is random
        Collections.shuffle(cards); //Collections is a Java framework that allows operation methods such as shuffle onto certain objects.
    }

    @JsonIgnore
    public Card getTopCard() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        Card temp = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return temp;
    }

    public boolean hasCards() {
        return cards.size() > 0;
    }

    public int size() { return cards.size(); }
}
