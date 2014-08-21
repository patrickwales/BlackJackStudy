package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import Main.Card;
import Main.Constants;
import Main.Hand;


public class HandTest {

	@Test
	public void testGetTotal21(){
		// Test jack / ace 
		Hand testHandJackAce = new Hand(25.0);
		Card jackCard = Constants.jack;
		Card aceCard  = Constants.ace;
		testHandJackAce.addCard(jackCard);
		testHandJackAce.addCard(aceCard);
		
		// Test ace / jack
		Hand testHandAceJack = new Hand(25.0);
		testHandAceJack.addCard(aceCard);
		testHandAceJack.addCard(jackCard);
		
		// Build
		Hand testHand2Jacks1Ace = new Hand(25.0);
		testHand2Jacks1Ace.addCard(jackCard);
		testHand2Jacks1Ace.addCard(jackCard);
		testHand2Jacks1Ace.addCard(aceCard);
		
		// Check
		assertEquals(testHandJackAce.getTotal(), 21);
		assertEquals(testHandAceJack.getTotal(), 21);
		assertEquals(testHand2Jacks1Ace.getTotal(), 21);
	}
	
	@Test
	public void testGetTotalTwoAces(){
		// Build
		Hand testHand = new Hand(25.0);
		Card aceCard = Constants.ace;
		testHand.addCard(aceCard);
		testHand.addCard(aceCard);
		
		// Check 
		assertEquals(testHand.getTotal(), 12);
	}
	
	@Test
	public void testGetSecondCard(){
		// TODO testGetSecondCard
	}
	
	@Test
	public void testContainsCard(){
		// Create a hand
		Hand hand = new Hand(25.0);
		Card ace = Constants.ace;
		Card two = Constants.two;
		hand.addCard(ace);
		hand.addCard(two);
		
		assertTrue(hand.containsCard(Constants.ace));
		assertTrue(hand.containsCard(Constants.two));
	}
	
	@Test
	public void testIsPair(){
		// TODO testIsPair
	}
}
