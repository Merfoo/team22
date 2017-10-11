package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
		Random rand = new Random(); //random number generator
		
		int index; //index of randomly chosen int
		Card temp; //will hold deck[index] and be placed somewhere else within deck
		
		for(int i = deck.size() - 1; i > 0; i--){ //for all cards in the deck
			index = rand.nextInt(i + 1); //will select a random number from [0-(i+1)]
			temp = deck.get(i); //save random card
			
			deck.set(index, deck.get(i)); //set random card to current card
			deck.set(i, temp); //set current card to random card
		}
		//System.out.print("test");
		//System.out.print("deck size is: " + deck.size());
        //for(int i = 0; i < 52; i++){
        //    System.out.print("card " + i + ": " + deck.get(i).getValue());
        //}
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
