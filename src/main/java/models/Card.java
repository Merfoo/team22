package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Card implements Serializable {
    public final int value;
    public final Suit suit;
    public final String textRepresentation;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;
        this.textRepresentation = this.toString();
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String cardValue = Integer.toString(this.value);

        return cardValue + " " + this.suit.toString();
    }
}
