package ie.gmit.dip;

public class DeckRunner { // Sets up the deck of cards.
	private Card card = new Card();
	private LinkedList deck = new LinkedList(card);
		
	public void deckRunner(){
		card.setSuit('H');
		card.setValue(14);
		card.setCardName("H.A");
		card.setScore(1);
		
		System.out.println("runing");
		   deck.addCard('H',2,"H.2",1);
		   deck.addCard('H',3,"H.3",1);
		   deck.addCard('H',4,"H.4",1);
		   deck.addCard('H',5,"H.5",1);
		   deck.addCard('H',6,"H.6",1);
		   deck.addCard('H',7,"H.7",1);
		   deck.addCard('H',8,"H.8",1);
		   deck.addCard('H',9,"H.9",1);
		   deck.addCard('H',10,"H.10",1);
		   deck.addCard('H',11,"H.J",1);
		   deck.addCard('H',12,"H.Q",1);
		   deck.addCard('H',13,"H.K",1);
		   deck.addCard('D',14,"D.A",0);
		   deck.addCard('D',2,"D.2",0);
		   deck.addCard('D',3,"D.3",0);
		   deck.addCard('D',4,"D.4",0);
		   deck.addCard('D',5,"D.5",0);
		   deck.addCard('D',6,"D.6",0);
		   deck.addCard('D',7,"D.7",0);
		   deck.addCard('D',8,"D.8",0);
		   deck.addCard('D',9,"D.9",0);
		   deck.addCard('D',10,"D.10",0);
		   deck.addCard('D',11,"D.J",0);
		   deck.addCard('D',12,"D.Q",0);
		   deck.addCard('D',13,"D.K",0);
		   deck.addCard('C',14,"C.A",0);
		   deck.addCard('C',2,"C.2",0);
		   deck.addCard('C',3,"C.3",0);
		   deck.addCard('C',4,"C.4",0);
		   deck.addCard('C',5,"C.5",0);
		   deck.addCard('C',6,"C.6",0);
		   deck.addCard('C',7,"C.7",0);
		   deck.addCard('C',8,"C.8",0);
		   deck.addCard('C',9,"C.9",0);
		   deck.addCard('C',10,"C.10",0);
		   deck.addCard('C',11,"C.J",0);
		   deck.addCard('C',12,"C.Q",0);
		   deck.addCard('C',13,"C.K",0);
		   deck.addCard('S',14,"S.A",0);
		   deck.addCard('S',2,"S.2",0);
		   deck.addCard('S',3,"S.3",0);
		   deck.addCard('S',4,"S.4",0);
		   deck.addCard('S',5,"S.5",0);
		   deck.addCard('S',6,"S.6",0);
		   deck.addCard('S',7,"S.7",0);
		   deck.addCard('S',8,"S.8",0);
		   deck.addCard('S',9,"S.9",0);
		   deck.addCard('S',10,"S.10",0);
		   deck.addCard('S',11,"S.J",0);
		   deck.addCard('S',12,"S.Q",13);
		   deck.addCard('S',13,"S.K",0);
		   
		   
	}

	public LinkedList setdeck(){
		return this.deck;
	}
	
}
