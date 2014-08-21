package Main;
import java.util.ArrayList;
import java.util.LinkedList;


public class Dealer extends Player {
	private LinkedList[] results;

	public Dealer(int numHands, Deck deck){
		super(numHands, deck);
	}
		
	public void playHand(){
		Hand hand = super.getHand();
		if(hand != null){
			while(hand.getTotal() < 17){
				super.hitHand();
			}
		}
	}
	
	public void recordResults(){
		// TODO record dealer outcome to results
	}

	public boolean isBlackJack() {
		Hand hand = super.getHand();
		if(hand != null){
			if(hand.getTotal() == 21 && hand.getNumCards() == 2)
				return true;
		}
		return false;
	}	
	
	public Card getShowingCard(){
		Hand hand = super.getHand();
		Card showingCard = hand.getSecondCard();
		return showingCard;
	}
	
	public boolean showingCardValueBetween(int min, int max){
		int value = getShowingCard().getValue();
		return min <= value && value <= max;
	}
}
