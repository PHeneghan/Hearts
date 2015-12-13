package ie.gmit.dip;

public class NodeImpl implements Node{
	private Card T;
	private Node next;

	public NodeImpl(){// The nodes going to be stored in the LinkedList
		T = null;
		next = null;		
	}
	
	@Override
	public Card getT() {
		// TODO Auto-generated method stub
		return this.T;
	}

	@Override
	public void setT(Card T) {
		// TODO Auto-generated method stub
		this.T = T;
	}

	@Override
	public Node getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

	@Override
	public void setNext(Node next) {
		// TODO Auto-generated method stub
		this.next = next;
	}


}
