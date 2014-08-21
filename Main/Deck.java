package Main;
import java.util.ArrayList;
import java.util.Random;


public class Deck {
	private ArrayList<Card> allCards;
	private int numDecks;
	
	public Deck(){
		this.numDecks = 1;
		this.allCards = new ArrayList<Card>();
		addDecks(numDecks);
		shuffle();
	}
	
	public Deck(int numDecks){
		this.numDecks = numDecks;
		this.allCards = new ArrayList<Card>();
		addDecks(numDecks);
		shuffle();
	}
	
	public static void main(String[] args){
		Deck deck = new Deck();
		System.out.println("Deck main done.");
	}
	
	public void addDeck(){
		addCard(Constants.ace, 4);
		addCard(Constants.two, 4);
		addCard(Constants.three, 4);
		addCard(Constants.four, 4);
		addCard(Constants.five, 4);
		addCard(Constants.six, 4);
		addCard(Constants.seven, 4);
		addCard(Constants.eight, 4);
		addCard(Constants.nine, 4);
		addCard(Constants.ten, 4);
		addCard(Constants.jack, 4);
		addCard(Constants.queen, 4);
		addCard(Constants.king, 4);
	}
	
	public void addDecks(int numDecks){
		for(int i = 0; i < numDecks; i++){
			addDeck();
		}
	}
	
	public void addCard(Card card, int numCards){
		for(int i = 0; i < numCards; i++){
			this.allCards.add(card);
		}
	}
	
	public Card getCard(){
		if(allCards.size() == 0){
			shuffle();
		}
		return allCards.remove(0);

	}
	
	public void shuffle(){
		// Add random cards to the shuffled deck until no more unshuffled cards
		Random random = new Random();
		int unshuffledIndex;
		ArrayList<Card> unshuffledCards = this.getAllCards();
		ArrayList<Card> shuffledCards = new ArrayList<Card>();
		while(unshuffledCards.size() > 0){
			// Randomly choose an index in the unshuffled deck
			unshuffledIndex = random.nextInt(allCards.size());
			
			// Add random card to shuffled deck
			shuffledCards.add(allCards.remove(unshuffledIndex));
		}
		// Set shuffled cards to allCards Deck
		this.allCards = shuffledCards;
	}
	
	public ArrayList<Card> getAllCards(){
		return this.allCards;
	}
	
}
