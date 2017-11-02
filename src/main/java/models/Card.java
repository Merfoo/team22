package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of for future assignments.
 */

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

        if(this.value == 11)
            cardValue = "J";

        else if(this.value == 12)
            cardValue = "Q";

        else if(this.value == 13)
            cardValue = "K";

        else if(this.value == 14)
            cardValue = "A";

        return cardValue + " " + this.suit.toString();
    }
}
