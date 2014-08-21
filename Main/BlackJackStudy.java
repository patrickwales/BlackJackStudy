package Main;
import java.util.LinkedList;


public class BlackJackStudy {
	private Game[] games;
	
	public BlackJackStudy(int numGamblers, int numGames, int numDecks, int numHands, double minBet){
		// Create games
		for(int i = 0; i < numGames; i++){
			this.games[i] = new Game(numGamblers, numDecks, numHands, minBet);
		}
		
	}
	
	public static void main(String[] args){
		// Create games
		BlackJackStudy study = new BlackJackStudy(1, 100, 8, 500, 25);
		
		// Play games
		study.playGames();
		study.recordGamesToExcel("BJ100Games500Hands");
	}
	
	public void playGames(){
		for(int i = 0; i < this.games.length; i++){
			this.games[i].play();
		}
	}
	
	public void recordGamesToExcel(String fileName){
		// TODO recordGamesToExcel
	}
	
	
}
