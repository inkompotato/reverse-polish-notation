
public class LList <E>  {
	
	private Node first;
	private Node current;
	private Node previous;
	private int size=0;
	

	public void add(E o) {
		Node node = new Node(o, null);
		if (first == null)
			addFirst(o);
		else {
			current.next = node;
			size++;
			
		/*current = first;
		while (current.next != null) {
			current = current.next;	
			size++;
			System.out.println("+1");
		}
		current.next = node;*/
		}
		
	}


	public void addFirst(E o) {
		if (first == null) {
			first = new Node(o);
			previous = null;
			current = first;
			size= 1;
			}
		else {
			Node tempo = new Node(o, first);
			first = tempo;
			current = first;
			size++;
		}
	}


	public void remove(){
		if (!isEmpty()) {
			if (previous == null){
				first = current.next;
				current = first;
			}
			else {
				previous.next = current.next;
				current = current.next;
			}
			size--;
		}
		
		else {
			System.out.println("List is empty");
		}
		
	}


	public boolean isEmpty() {
		return (first == null);
	}


	public E current() {
		return current.data;
	}


	public int getSize() {
		return size;
	}


	public void reset() {
		current = first;
		previous = null;
	}


	public void next() {
		current = current.next;
		if ( previous == null) previous = first;
		else previous = previous.next;
	}


	public boolean endoflist() {
		return (current == null);
	}
	
	public String printList() {
		String s ="[";
		this.reset();
		while (!endoflist()) {
			s += current.getData()+"; ";
			this.next();
		}
		return s + "]";
	}

	private  class Node {
		E data;
		Node next = null;


		public Node (E o) {
			this.data = o;
		}

		public Node (E o, Node next) {
			this.data = o;
			this.next = next;
		}

		public E getData() {
			return this.data;
		}
	}

}
