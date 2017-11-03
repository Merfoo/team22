package models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CardColumn {
    public final java.util.List<Card> cards = new ArrayList<>();

    public CardColumn() {

    }

    public void add(Card card) {
        cards.add(card);
    }

    @JsonIgnoreProperties
    public Card getTop() {
        return cards.get(cards.size() - 1);
    }

    public Card removeTop() {
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);

        return card;
    }

    public boolean hasCards() {
        return !cards.isEmpty();
    }
}
