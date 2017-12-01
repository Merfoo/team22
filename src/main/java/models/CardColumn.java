package models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS,
                include = JsonTypeInfo.As.PROPERTY,
                property = "type")
@JsonSubTypes({
        @Type(value = OriginalCardColumn.class),
        @Type(value = SpanishCardColumn.class)
})

public abstract class CardColumn {
    public final java.util.List<Card> cards = new ArrayList<>();
    public boolean canRemoveTopCard = false;

    public void add(Card card) {
        cards.add(card);
    }

    @JsonIgnore
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
