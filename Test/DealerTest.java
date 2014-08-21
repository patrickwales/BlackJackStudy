package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Main.Constants;
import Main.Dealer;
import Main.Deck;
import Main.Hand;

public class DealerTest {

	@Test
	public void testPlayHand(){
		// Create dealer object, 1 hand, 8 decks and deal
		Dealer dealer = new Dealer(1, new Deck(8));
		
		// Keep going until has to hit beyond dealt hand
		do{
			// If already a hand remove
			if(dealer.getLiveHands().peek() != null){
				dealer.getLiveHands().remove();
			}
			// Deal cards
			dealer.dealCard();
			dealer.dealCard();
			
			// Play hand
			dealer.playHand();
		
		} while(dealer.getHand().getNumCards() > 3);
		
		// Check >= 17
		assertTrue(dealer.getHand().getTotal() >= 17);
	}
	
	@Test
	public void testBlackJack(){
		// Instantiate dealer and hand with black jack
		Dealer dealer = new Dealer(1, new Deck(8));
		Hand hand = new Hand();
		hand.addCard(Constants.ace);
		hand.addCard(Constants.jack);
		dealer.setLiveHand(hand);
		
		// Test if black jack
		assertTrue(dealer.isBlackJack());
	}
	
	@Test
	public void testDealCard() {
		// Create dealer object, 1 hand, 8 decks
		Dealer dealer = initDealerAndDeal();
		
		// Check if have 2 cards
		Hand hand = dealer.getLiveHands().remove();
		assertEquals(hand.getNumCards() == 2, true);
	}
	
	@Test
	public void testHitHand(){
		// Create dealer object, 1 hand, 8 decks
		Dealer dealer = initDealerAndDeal();
		
		// Hit hand
		dealer.hitHand();
		dealer.hitHand();
		assertEquals(dealer.getHand().getNumCards() == 4, true);
	}
	
	@Test
	public void testRecordResults(){
		// TODO testRecordResults
	}
	
	public Dealer initDealerAndDeal(){
		// Create dealer object, 1 hand, 8 decks
		Dealer dealer = new Dealer(1, new Deck(8));
		
		// Deal 2 cards to dealer
		dealer.dealCard();
		dealer.dealCard();
		
		return dealer;
	}
	
	@Test
	public void testGetShowingCard(){
		// TODO testGetShowingCard	
	}
	
	@Test
	public void testShowingCardValueBetween(){
		// TODO testShowingCardValueBetween
	}
	

}
