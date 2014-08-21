package Main;
import java.util.LinkedList;
import java.util.Queue;


public abstract class Player {
	private Queue<Hand> liveHands;
	private Deck deck;
	private LinkedList[] results;
	private Double minBet;
	
	public Player(int numHands, Deck deck){
		// Set results
		this.results = new LinkedList[numHands];
		for(int i = 0; i < numHands; i++){
			this.results[i] = new LinkedList();
		}
		// Init hand queues
		liveHands = new LinkedList<Hand>();
		
		// Init deck
		this.deck = deck;
	}
	
	public void dealCard(){
		Card card = deck.getCard();
		Hand hand;
		
		// If no hands then create one
		if(liveHands.size() == 0){
			hand = new Hand(this.minBet);
			hand.addCard(card);
			liveHands.add(hand);
		}
		// If hand then add another card 
		else{
			hand = liveHands.peek();
			hand.addCard(card);
		}
	}
	
	public abstract void playHand();
	
	public void setLiveHand(Hand hand){
		this.liveHands.add(hand);
	}
	
	public void hitHand(){
		if(this.liveHands.size() > 0){
			Card card = this.deck.getCard();
			this.liveHands.peek().addCard(card);
		}
	}
	
	public void recordOutcomes(){
		// TODO
	}
	
	public Queue<Hand> getLiveHands(){
		return this.liveHands;
	}
	
	public Hand getHand(){
		if(hasHand()){
			return getLiveHands().peek();
		}
		return null;
	}
	
	public boolean hasHand(){
		return getLiveHands() != null && getLiveHands().peek() != null;
	}
}
