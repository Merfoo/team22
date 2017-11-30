package models;

import java.util.ArrayList;
import java.util.Collections;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = OriginalDeck.class)
})
public abstract class Deck{

    public java.util.List<Card> cards = new ArrayList<Card>(52);
    protected int originalSize;

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

    public int originalSize() { return originalSize; }
}
