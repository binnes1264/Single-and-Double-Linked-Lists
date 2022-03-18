
public class doubLL<T> {
	
	private Node<T> head = null;
	private Node<T> tail = null;
	public Node<T> lastNode = null;
		
		//Nested Node class
		public static class Node<T>{
			public T element;
			private Node<T> next;
			private Node<T> prev;
		
			public Node(T e, Node<T> p, Node<T> n) {
				element = e;
				prev = p;
				next = n;
			}
		}
		
		//Returns head to start printing in Driver
	public Node<T> getTail() {
		return tail;
	}
		
		//Returns previous node to print backwards in Driver
	public Node<T> prev(Node<T> n2){
		return n2.prev;
	}
		
	//Creates initial DLL	
	public doubLL() {}
	
	//Adds new Numerology object to list and sets each next and previous value
	public void addNode(T num) {
		//Creates new node
		Node<T> n2 = new Node<>(num, null, null);
		
		if(head == null) {
			head = n2;
			tail = n2;
			lastNode = n2;
			
		}else {
			lastNode.next = n2;
			n2.prev = lastNode;
			tail = n2;
			lastNode = n2;
		}
		
	}
	
	
}
