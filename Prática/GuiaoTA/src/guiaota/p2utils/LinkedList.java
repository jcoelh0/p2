package guiaota.p2utils;

public class LinkedList<E> {

	/**
	 * {@code LinkedList} constructor, empty so far.
	 */
	public LinkedList() {
	}

	/**
	 * @return Number of elements in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the list is empty
	 *
	 * @return {@code true} if list empty, otherwise {@code false}.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return First element in the list
	 */
	public E first() {
		assert !isEmpty() : "empty!";

		return first.elem;
	}
	
	//1 - ITERATIVA
	public int count(E e){
		int c = 0;
		for (Node<E> n = first; n != null; n = n.next) {
			if(n.elem.equals(e)) c++;
		}
		return c;
	}
	
	//1 - RECURSIVA
//	int count(E e){
//		return count(first,e);
//	}
//	int count(Node<E> n, E e){
//		if(n == null) return 0;
//		return count(n.next,e)+(n.elem.equals(e) ? 1 : 0);
//	}
	
	//2 - ITERATIVA
	public int indexOf(E e){
		int pos = 0;
		for (Node<E> n = first; n != null; n = n.next,pos++) {
			if(n.elem.equals(e))
				return pos;
		}
		return -1;
	}
	
	//2 - RECURSIVA
//	public int indexOf(E e){
//		return indexOf(first,0,e);
//	}
//	private int indexOf(first,0,e){
//		if(n == null) return -1;
//		if(n.elem.equals(e)) return pos;
//		return indexOf(n.next,pos+1,e);
//	}
	
	//3 - ITERATIVA
	public LinkedList<E> cloneReplace(E x, E y){
		LinkedList<E> nl = new LinkedList<E>();
		for(Node<E> n = first; n != null; n = n.next){
			if(n.elem.equals(x))
				nl.addLast(y);
			else
				nl.addLast(n.elem);
		}
		return nl;
	}	
	//3 - RECURSIVA
//	public LinkedList<E> cloneReplace(E x, E y){
//		return cloneReplace(first,x,y);
//	}
//	private LinkedList<E> cloneReplace(Node<E> n, E x, E y){
//		if(n == null)
//			return new LinkedList<E>();
//		LinkedList<E> nl = cloneReplace(n.next,x,y);
//		
//		if(n.elem.equals(x))
//			nl.addFirst(y);
//		else
//			nl.addFirst(n.elem);
//		return nl;
//	}
	
	//4 - ITERATIVA
	public LinkedList<E> cloneSublist(int start, int end){
		assert (start >= 0) && (end <= size) && (end >= start);
		LinkedList<E> nl = new LinkedList<E>();
		int pos = 0;
		for(Node<E> n = first; n != null; n = n.next, pos++)
			if(pos >= start && pos < end)
				nl.addLast(n.elem);
		return nl;
	}
	
	//4 - RECURSIVA
//	public LinkedList<E> cloneSublist(int start, int end){
//		LinkedList<E> nl = new LinkedList<E>();
//		nl.cloneSublist(first, 0, start, end);
//		return nl;
//	}
//	
//	private void cloneSublist(Node<E> n,int pos, int start, int end){
//		if(n == null || pos >= end) return;
//		if(pos >= start && pos < end)
//			this.addLast(n.elem);
//		this.cloneSublist(n.next,pos + 1,start,end);
//	}

	
	public LinkedList<E> cloneExceptSublist(int start, int end){
		assert (start >= 0) && (end <= size) && (end >= start);
		LinkedList<E> nl = new LinkedList<E>();
		int pos = 0;
		for(Node<E> n = first; n != null; n = n.next, pos++)
			if(pos < start || pos >= end)
				nl.addLast(n.elem);
		return nl;
	}
	
	public void removeSublist(int start, int end){
		int dif = end - start;
		assert (start >= 0) && (end <= size) && (end >= start);
		
		int pos = 0;
		for(Node<E> n = first; n != null; n = n.next, pos++){
			if(pos < start || pos >= end){
				addLast(n.elem);
			}
			else{
				addFirst(n.elem);
			}
		}
		pos = 0;
		Node<E> n = first;
		while(pos < dif){
			removeFirst();
			pos++;
		}
	}

	/**
	 * @return Last element in the list
	 */
	public E last() {
		assert !isEmpty() : "empty!";

		return last.elem;
	}

	/**
	 * Adds a new element to the start of the list
	 */
	public void addFirst(E e) {
		first = new Node<>(e, first);
		if (isEmpty()) {
			last = first;
		}
		size++;

		assert !isEmpty() && first().equals(e);
	}

	/**
	 * Adds a new element to the end of the list
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<>(e);
		if (isEmpty()) {
			first = newest;
		} else {
			last.next = newest;
		}
		last = newest;
		size++;

		assert !isEmpty() && last().equals(e);
	}

	/**
	 * Removes the first element in the list
	 */
	public void removeFirst() {
		assert !isEmpty() : "empty!";
		first = first.next;
		size--;
		if (isEmpty()) {
			last = null;
		}
	}

	public String toString() {
		if (size() == 0) {
			return "[ ]";
		}
		String s = "[ " + first.elem.toString();
		if (size() == 1) {
			return s + " ]";
		}
		Node<E> n = first.next;
		while (n != null) {
			s += ("," + n.elem.toString());
			n = n.next;
		}
		return s + " ]";
	}

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

}
