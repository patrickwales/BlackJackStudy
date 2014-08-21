package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Main.Card;
import Main.Deck;

public class DeckTest {

	@Test
	public void testHaveAllCards() {
		// Create one deck
		Deck deck = new Deck(1);
		
		// Count cards
		int deckCount = deck.getAllCards().size();
		assertEquals(deckCount, 52);
		
		// Create multiple decks
		deck = new Deck(8);
		
		// Count multiple decks
		deckCount = deck.getAllCards().size();
		assertEquals(deckCount, 52 * 8);	
	}
	
	@Test 
	public void testShuffle(){
		// Create two decks
		Deck deckOne = new Deck(1);
		Deck deckTwo = new Deck(1);
		
		// Set equal to false if not the same order
		boolean equal = true;
		ArrayList<Card> allCardsOne = deckOne.getAllCards();
		ArrayList<Card> allCardsTwo = deckTwo.getAllCards();
		for(int i = 0; i < allCardsOne.size(); i++){
			if(!allCardsOne.get(i).getName().equals(allCardsTwo.get(i).getName())){
				equal = false;
			}
		}
		// Test if two decks are the same in order
		assertEquals(equal, false);
	}
	
	
}
