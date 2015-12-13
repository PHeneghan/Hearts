package ie.gmit.dip;

import java.util.Scanner;

public class PlayHearts {
	private static DeckRunner run = new DeckRunner();
	
	private Card[] suffledDeck = new Card[52];
	private LinkedList hand1 = null;
	private LinkedList hand2 = null;
	private LinkedList hand3 = null;
	private LinkedList hand4 = null;
	
 	public PlayHearts(){
 		LinkedList deck = run.setdeck();
 		boolean play = true;
 		boolean firstHand = true;
 		boolean c2 = false;
 		boolean invalid = false;
 		int whoPlays = 0;
 		int player1Score = 0;
 		int player2Score = 0;
 		int player3Score = 0;
 		int player4Score = 0;
 		int player1ScoreT = 0;
 		int player2ScoreT = 0;
 		int player3ScoreT = 0;
 		int player4ScoreT = 0;
 		char suitPlayed = 0;
 		int cardPlayed = 0;
 		int cardsGoTo = 0;
 		int loosingCard = 0;
 		Card[] played = new Card[4];
 		int[] order = new int[4];
 		Scanner s = new Scanner(System.in);
 		boolean winner = true;
 		
	
		
 		while(winner){// Plays until someone looses
 			LinkedList deck1 = deck;	
 			suffle(deck1);
			deal();
			for(int a = 0; a<13;a++){// Loops through hand
				System.out.println("Your Cards");
			hand1.print();
			System.out.println();
			if(firstHand){// Two of clubs must be played first
				System.out.println("The Player");
				if(hand1.contains("C.2")){
					whoPlays = 1;
					System.out.println("You play first, play the 2 of clubs (C.2)");
					firstHand = false;
				}else if(hand2.contains("C.2")){
					whoPlays = 2;
					c2 = true;
					firstHand = false;
				}else if(hand3.contains("C.2")){
					whoPlays = 3;
					c2 = true;
					firstHand = false;
				}else{
					whoPlays = 4;
					c2 = true;
					firstHand = false;
				}
				for(int x = 0; x<played.length; x++){// Controls each hand
					if(whoPlays ==1){ // Human player code
						Card cardPlayedOne = null;
						if(x==0){
							System.out.println("Play a Card");
							String playedCard = s.next().toUpperCase();
							cardPlayedOne = hand1.play(playedCard);
							played[x] = cardPlayedOne;
							System.out.println();
							whoPlays ++;
							suitPlayed = cardPlayedOne.getSuit();
							cardPlayed = cardPlayedOne.getValue();
						}else{
						System.out.println("Play a Card");
						String playedCard = s.next();
					
						if(hand1.hasSuit(playedCard) != suitPlayed){
							while(invalid){
								System.out.println("Invalid Card, must match suit");
								playedCard = s.next().toUpperCase();
								if(hand1.hasSuit(playedCard)==suitPlayed){
									invalid = false;
								}
						}
						invalid = true;
						cardPlayedOne = hand1.play(playedCard);
						}
						played[x] = cardPlayedOne;
						order[x]=1;
						System.out.println();
						whoPlays ++;
					}
				}else if(whoPlays ==2){// Computer players code
					Card cardPlayedOne = null;
					if(x==0 && c2){
						cardPlayedOne=hand2.play("C.2");
						c2 = false;
					}else{
						if(hand2.hasSuitB(suitPlayed)){
							cardPlayedOne=hand2.getCardToPlay(suitPlayed);									
						}else{
							Node letsPlay = hand2.pop();
							cardPlayedOne = letsPlay.getT();
						}
					}
					played[x] = cardPlayedOne;
					order[x]=2;
					System.out.println();
					whoPlays ++;
				}else if(whoPlays ==3){
					Card cardPlayedOne = null;
					if(x==0 && c2){
						cardPlayedOne=hand3.play("C.2");
						c2=false;
					}else if(x==0 && !(c2)){
						Node letsPlay = hand3.pop();
						cardPlayedOne = letsPlay.getT();
					}else{
						if(hand3.hasSuitB(suitPlayed)){
							cardPlayedOne=hand3.getCardToPlay(suitPlayed);									
						}else{
							Node letsPlay = hand3.pop();
							cardPlayedOne = letsPlay.getT();
						}
						
					}
					played[x] = cardPlayedOne;
					order[x]=3;
					System.out.println();
					whoPlays ++;						
				}else if(whoPlays ==4){
					Card cardPlayedOne = null;
					if(x==0 && c2){
						cardPlayedOne=hand4.play("C.2");
								c2=false;
							}else{
								if(hand4.hasSuitB(suitPlayed)){
									cardPlayedOne=hand4.getCardToPlay(suitPlayed);									
								}else{
									Node letsPlay = hand4.pop();
									cardPlayedOne = letsPlay.getT();
								}
							}
							played[x] = cardPlayedOne;
							order[x]=4;
							System.out.println();						
							whoPlays = 1;
						}
					}
					Card[] temp = played;
					for(int c=1; c<temp.length; c++){
						if(temp[c].getSuit() != suitPlayed){
							temp[c]=null;							
						}
					}
					
					for(int d=0; d<temp.length;d++){
						if(temp[d] != null){
							if(temp[d].getValue()>loosingCard){
								loosingCard = temp[d].getValue();
								cardsGoTo = order[d];
								whoPlays = order[d];
							}
						}
					}
					
					if(cardsGoTo==1){
						for(int e = 0; e<played.length; e++){
							player1Score = player1Score + played[e].getScore();
						}
					}else if(cardsGoTo==2){
						for(int e = 0; e<played.length; e++){
							player2Score = player2Score + played[e].getScore();
						}
					}else if(cardsGoTo==3){
						for(int e = 0; e<played.length; e++){
							player3Score = player3Score + played[e].getScore();
						}
					}else if(cardsGoTo==4){
						for(int e = 0; e<played.length; e++){
							player4Score = player4Score + played[e].getScore();
						}
					}
					firstHand = true;
					
				}
				if(player1Score == 26){
					player2ScoreT = player2ScoreT + 26;
					player3ScoreT = player3ScoreT + 26;
					player4ScoreT = player4ScoreT + 26;
				}else if(player2Score == 26){
					player1ScoreT = player1ScoreT + 26;
					player3ScoreT = player3ScoreT + 26;
					player4ScoreT = player4ScoreT + 26;
				}else if(player3Score == 26){
					player1ScoreT = player1ScoreT + 26;
					player2ScoreT = player2ScoreT + 26;
					player4ScoreT = player4ScoreT + 26;
				}else if(player4Score == 26){
					player1ScoreT = player1ScoreT + 26;
					player2ScoreT = player2ScoreT + 26;
					player3ScoreT = player3ScoreT + 26;
				}else{
					player1ScoreT = player1ScoreT + player1Score;
					player2ScoreT = player2ScoreT + player2Score;
					player3ScoreT = player3ScoreT + player3Score;
					player4ScoreT = player4ScoreT + player4Score;
				}
				System.out.println("Score: \nPlayer 1: "+ player1ScoreT + "\nPlayer 2:" + player2ScoreT + "\nPlayer 3:" + player3ScoreT + "\nPlayer 4:" + player4ScoreT);
				player1Score=0;
				player2Score=0;
				player3Score=0;
				player4Score=0;				
			}	
 		}
 		if(player1Score>=100 || player2Score>=100 ||player3Score>=100 ||player4Score>=100  ){
 			winner = false;
 		}
	
 	}
	
	
	
	public void suffle(LinkedList deck){// Creates a Card array containing all 52 cards in random positions 
		LinkedList newDeck = deck;
		Card[] tempDeck = new Card[52];
		for(int i = 0; i<suffledDeck.length; i++){
			Node card = newDeck.pop();
			int j = (int) ( Math.random() * 52 );
			while (tempDeck[j] != null){
				j = (int) ( Math.random() * 52 );
			}
			tempDeck[j] = card.getT();
		}		
		this.suffledDeck = tempDeck;
	}
	
	public void deal(){//Deals the deck into 4 different hands
		LinkedList handOne = null;
		LinkedList handTwo = null;
		LinkedList handThree = null;
		LinkedList handFour = null;
		for(int i = 0; i<suffledDeck.length; i++){
			if(i%4 == 0){
				if (handOne == null){
					handOne = new LinkedList(suffledDeck[i]);
				}else{
					handOne.append(suffledDeck[i]);
				}
			}else if(i%4 == 1){
				if (handTwo == null){
					handTwo = new LinkedList(suffledDeck[i]);
				}else{
					handTwo.append(suffledDeck[i]);
				}
			}else if(i%4 == 2){
				if (handThree == null){
					handThree = new LinkedList(suffledDeck[i]);
				}else{
					handThree.append(suffledDeck[i]);
				}
			}else if(i%4 == 3){
				if (handFour == null){
					handFour = new LinkedList(suffledDeck[i]);
				}else{
					handFour.append(suffledDeck[i]);
				}
			}
			this.hand1 = handOne;
			this.hand2 = handTwo;
			this.hand3 = handThree;
			this.hand4 = handFour;
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean play = true;
		run.deckRunner();
		while(play){
			new PlayHearts();
			System.out.println("Enter 1 to play again, 2 quit");
			int n = s.nextInt();
			if(n != 1){// Makes it easy to quit, unlikely people will want to play again
				play = false;
			}
		}
		
		
	}
}
