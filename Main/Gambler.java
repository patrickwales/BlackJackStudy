package Main;
import java.util.LinkedList;
import java.util.Queue;


public class Gambler extends Player {
	private Dealer dealer;
	private Queue<Hand> finishedHands;
	
	public Gambler(int numHands, Dealer dealer, Deck deck) {
		super(numHands, deck);
		this.dealer = dealer;
		this.finishedHands = new LinkedList<Hand>();
	}

	@Override
	public void playHand() {
		Queue<Hand> liveHands = super.getLiveHands();
		Hand curHand = liveHands.poll();
		
		// while there are hands
		while(curHand != null){
			// If should split
			if(shouldSplit(curHand)){
				splitHand(curHand);
			}
			// If should double
			else if(shouldDouble(curHand)){
				doubleHand(curHand);
			}
			// While should hit
			else if(shouldHit(curHand)){
				hitHand(curHand);
			}
			// If done hitting
			if(isDoneHitting(curHand)){
				finishedHands.add(curHand);
			}
			// Get the next hand
			curHand = super.getLiveHands().poll();
		}
		
	}
	
	public boolean shouldHit(Hand dealerHand){
		// TODO shouldHit
		return false;
	}
	
	public boolean shouldSplit(Hand dealerHand){
		// Get player hand
		Hand playerHand = super.getHand();
		
		// Get player total, dealer showing value
		int playerTotal = playerHand.getTotal();
		int showingCardValue =  this.dealer.getShowingCard().getValue();
		
		// Split cases
		if(playerTotal == 12 && dealer.showingCardValueBetween(4, 6)){
			return true;
		} else if(playerTotal == 13 && dealer.showingCardValueBetween(2, 6)){
			return true;
		} else if(playerTotal == 14 && dealer.showingCardValueBetween(2, 6)){
			return true;
		} else if(playerTotal == 15 && dealer.showingCardValueBetween(2, 6)){
			return true;
		} else if(playerTotal == 16 && dealer.showingCardValueBetween(2, 6)){
			return true;
		} else if(playerTotal == 17){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.seven) && showingCardValue == 2){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.seven) && dealer.showingCardValueBetween(7, 8)){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.seven) && dealer.getShowingCard().equals(Constants.ace)){
			return true;
		} 
		return false;
	}
	
	public boolean shouldDouble(Hand dealerHand){
		// Get player hand 
		Hand playerHand = super.getHand();
		
		// Get player total, dealer showing value
		int playerTotal = playerHand.getTotal();
		int showingCardValue =  this.dealer.getShowingCard().getValue();
		
		// Double cases
		if(playerTotal == 8 && dealer.showingCardValueBetween(5, 6)){
			return true;
		} else if(playerTotal == 9 && showingCardValue < 7){
			return true;
		} else if(playerTotal == 10 && showingCardValue < 10){
			return true;
		} else if(playerTotal == 11){
			return true;
		} else if(playerHand.getNumCards() != 2){
			return false;
		} else if(shouldDoubleAces(playerHand, showingCardValue)){
			return true;
		}
		return false;
	}
	
	public boolean shouldDoubleAces(Hand playerHand, int showingCardValue){
		if(playerHand.containsCards(Constants.ace, Constants.two) && 
				  dealer.showingCardValueBetween(4, 6)){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.three) && 
				  dealer.showingCardValueBetween(4, 6)){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.four) && 
				  dealer.showingCardValueBetween(4, 6)){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.five) && 
				  dealer.showingCardValueBetween(4, 6)){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.six) && 
				  dealer.showingCardValueBetween(2, 6)){
			return true;
		} else if(playerHand.containsCards(Constants.ace, Constants.seven) && 
				  showingCardValue == 6){
			return true;
		}
		return false;
	}
	
	public boolean isDoneHitting(Hand dealerHand){
		// TODO isDoneHitting
		return false;
	}
	
	public void splitHand(Hand curHand){
		// TODO splitHand
	}
	
	public void doubleHand(Hand curHand){
		curHand.doubleBet();
	}
	
	public void hitHand(Hand curHand){
		// TODO hitHand
	}
	
	public Hand getHand(){
		if(hasHand()){
			return super.getLiveHands().peek();
		}
		return null;
	}

}
