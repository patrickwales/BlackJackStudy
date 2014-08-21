package Main;



public class Game {

	private Gambler[] gamblers; 
	private Dealer dealer;
	private Deck deck;
	private double minBet;
	private int numHands;
	private int curHand;
	private BlackJackStudy study;
	
	public Game(int numGamblers, int numDecks, int numHands, double minBet){
		// Create the deck
		this.deck = new Deck(numDecks);
		
		// Create dealer
		this.dealer = new Dealer(numHands, deck);
		
		// Set the min bet
		this.minBet = minBet;
		
		// Create players
		this.gamblers = new Gambler[numGamblers];
		for(int i = 0; i < numGamblers; i++){
			gamblers[i] = new Gambler(numHands, dealer, deck);
		}

		this.curHand = 0;
		this.numHands = numHands;
	}
	
	public void play(){
		// For every hand 
		for(int i = 0; i < numHands; i++){
			// Deal cards to players and dealer
			dealCards();
			
			// Check if dealer has Black Jack
			if(!dealer.isBlackJack()){
				
				// Split, double, hit
				playersPlayHands();
				
				// Hit until 17
				dealerPlayHand();
			} 
			// Save result to players results
			playersRecordOutcomes();
		}
	}
	
	public void dealCards(){
		// Deal two rounds of cards
		for(int i = 0; i < 2; i++){
			
			// Deal one card to each player
			for(Player player : this.gamblers){
				player.dealCard();
			}
			// Deal a card to the dealer
			this.dealer.dealCard();
		}
	}
	
	public void playersPlayHands(){
		// Player play hands
		for(Player player : this.gamblers){
			player.playHand();
		}
	}
	
	public void dealerPlayHand(){
		this.dealer.playHand();
	}
	
	public void playersRecordOutcomes(){
		for(Gambler gambler : gamblers){
			gambler.recordOutcomes();
		}
	}
}
