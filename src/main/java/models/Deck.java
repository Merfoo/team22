package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck{

  public java.util.List<Card> deck = new ArrayList<>();

  public void shuffle() {
      // shuffles the deck so that it is random
      Collections.shuffle(deck); //Collections is a Java framework that allows operations methods such as shuffle onto certain objects.
  }

  public void dealFour() {
      // remove the top card from the deck and add it to a column; repeat for each of the four columns
      for(int i = 0; i < 4; i++){
        this.addCardToCol(i, deck.remove(0));
      }
  }

}
