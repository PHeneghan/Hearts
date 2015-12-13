package ie.gmit.dip;

public class LinkedList {
	Node root = new NodeImpl();
	

    public LinkedList(Card card) {// Sets the first Card in the list
        root.setT(card);
        
    }
    
    public void addCard(char suit, int value, String cardName, int score) {//Creates the card objects to had to the list.
    	Card newCard = new Card();
    	newCard.setSuit(suit);
    	newCard.setValue(value);
    	newCard.setCardName(cardName);
    	newCard.setScore(score);
    	append(newCard);
    }
    
    
    public void append(Card card) {// adds nodes to the list
	   Node newNode = new NodeImpl(); 
	   Node tmpNode = root;
	    while (tmpNode.getNext() != null) {
	        tmpNode = tmpNode.getNext();
	    }
	    newNode.setT(card);// Adds card to the node	    
	    tmpNode.setNext(newNode);// Adds Node to the next position of the previous node
    }
   
  
	public Node pop(){// Removes first node.
		Node temp = root.getNext();
		Node item = root;
		root = null;
		root = temp;
		return item;
	}

   public void print() {// Prints the Card name of each Node
	   Node tmpNode = root;
       while (tmpNode != null) {
    	   Card card =tmpNode.getT();
    	   System.out.print(card.getCardName() + " ");
           tmpNode = tmpNode.getNext();
       }  
   }
   
  public boolean contains(String card){// Checks if a card is in a list
	  Node tmpNode = root;
      boolean contains = false;
	  while (tmpNode != null) {
		  if(tmpNode.getT().getCardName().equals(card)){
			  contains = true;
			  break;
		  }
		  tmpNode = tmpNode.getNext();
      }  
	  return contains;
  }
  
  public Card play(String played){// Removes a Node from antwhere in the list
	  Node item = null;
	  Node previous = null;
	  Node tmpNode = root;
	  if(root.getT().getCardName().equals(played)){// Takes the first node
		  Node temp = root.getNext();
		  item = root;
		  root = null;
		  root = temp;
	  }else{
		  while (tmpNode != null) { // Removes any other node
			  if(tmpNode.getT().getCardName().equals(played)){
				  	Node temp = tmpNode.getNext();
				  	item = tmpNode;
				  	tmpNode = null;
				  	tmpNode = temp;
				  	previous.setNext(temp);
				}else{
					previous = tmpNode;
					tmpNode = tmpNode.getNext();
			  }
	      } 
	  }
	  return item.getT();
  }
  
  public char hasSuit(String c){// Checks if Cards have a certain suit, returns suit name.
	  char[] card = c.toCharArray();
	  Node tmpNode = root;
      boolean contains = true;
      while (tmpNode != null) {
		  if(tmpNode.getT().getSuit() == card[0]){
			  contains = false;
			  break;
		  }
		  tmpNode = tmpNode.getNext();
      }  
      if(contains){
    	  card[0] = 'a';
      }
	  return card[0];
  }
  
  public boolean hasSuitB(char c){//Checks if Cards have a certain suit
	  char card = c;
	  Node tmpNode = root;
      boolean has = false;
      while (tmpNode != null) {
		  if(tmpNode.getT().getSuit() == card){
			  has = true;
			  break;
		  }
      }
      return has;
  } 
  
  public Card getCardToPlay(char s){// Returns Cards of a particular suit
	  Node item = null;
	  Node previous = null;
	  Node tmpNode = root;
	  if(root.getT().getSuit()==s){
		  Node temp = root.getNext();
		  item = root;
		  root = null;
		  root = temp;
	  }else{
		  while (tmpNode != null) {
			  if(tmpNode.getT().getSuit()==s){
				  	Node temp = tmpNode.getNext();
				  	item = tmpNode;
				  	tmpNode = null;
				  	tmpNode = temp;
				  	previous.setNext(temp);
				}else{
					previous = tmpNode;
					tmpNode = tmpNode.getNext();
			  }
	      } 
	  }
	  return item.getT();
  }

}
