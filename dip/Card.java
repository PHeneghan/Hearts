package ie.gmit.dip;

public class Card {// The card class is an object that holds all card information
	private char suit;// Stores suit
	private int value;// Stores the value from th2 two which has value 2 to the Ace with value 14
	private String cardName;
	private int score;// Stores the score received when the card is won. 

	public Card(){
		super();
		suit = 0;
		value = 0;
		cardName= null;
		score = 0;
	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
