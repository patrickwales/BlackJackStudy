package Main;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	private Double bet;
	
	public Hand(Double bet){
		this.cards = new ArrayList<Card>();
		this.bet = bet;
	}
	
	public int getTotal(){
		int numAces = 0;
		int total = 0;
		// Add all non aces
		for(Card card : cards){
			if(card.equals(Constants.ace)){
				numAces++;
			} else{
				total += card.getValue();
			}
		}
		// Find the highest value including aces
		for(int i = numAces; 0 < i; i--){
			if(total + i * 11 <= 21){
				total += 11;
			} else {
				total += 1;
			}
		}
		return total;
	}
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	public int getNumCards(){
		return cards.size();
	}
	
	public Card getSecondCard(){
		if(cards != null && cards.get(1) != null){
			return cards.get(1);
		}
		return null;
	}
	
	public boolean containsCard(Card card){
		return cards.contains(card);
	}
	
	public boolean containsCards(Card cardOne, Card cardTwo ){
		return cards.contains(cardOne) && cards.contains(cardTwo);
	}
	
	public void doubleBet(){
		this.bet = this.bet * 2;
	}
	
	public boolean isPair(Card card){
		return getNumCards() == 2 && (card.getValue() * 2) == getTotal();
	}
}

