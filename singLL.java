public class singLL<T> {
	
	private Node<T> head = null;
	private Node<T> tail = null;
	public Node<T> lastNode = null;
	
		//Nested Node class
		public static class Node<T>{
			public T element;
			private Node<T> next;
		
			public Node(T e, Node<T> n) {
				element = e;
				next = n;
			}	
			
		}
		
		//Returns head to start printing in Driver
	public Node<T> getHead() {
		return head;
	}
		
		//Returns next node to print forwards in Driver
	public Node<T> next(Node<T> n1){
		return n1.next;
	}
	
	//Creates initial SLL
	public singLL() {}
	
	//Adds new Numerology object to list and sets each next value
	public void addNode(T num) {
		//Creates new node
		Node<T> n1 = new Node<>(num, null);
		
		if(head==null) {
			head = n1;
			tail = n1;
			lastNode = n1;
		}else {
			lastNode.next = n1;
			tail = n1;
			lastNode = n1;
		}
		
	}
}
