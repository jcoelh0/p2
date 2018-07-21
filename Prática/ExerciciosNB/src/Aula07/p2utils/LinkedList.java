package Aula07.p2utils;

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

    public LinkedList<E> clone(){
        LinkedList<E> cloned = new LinkedList<E>();
        cloned.clone(this.first);
        return cloned;
    }
    
    private void clone(Node<E> n){
        if(n != null){
            this.addLast(n.elem);
            this.clone(n.next);
        }
    }
    
    
    public LinkedList<E> reverse(){
        LinkedList<E> reversed = new LinkedList<E>();
        reversed.reverse(this.first);
        return reversed;
    }
    
    private void reverse(Node<E> n){
        if(n != null){
            this.addFirst(n.elem);
            this.reverse(n.next);
        }
    }
    
    public E get(int pos){
        assert pos >= 0 && pos <= size() -1;
	return get(first,pos);
    }
    
    private E get(Node<E> n, int pos){
	if(n == null) return null;
	if(pos == 0) return n.elem; 
	return get(n.next,pos - 1);
    }
    
    public LinkedList<E> concatenate(LinkedList<E> lst){
	LinkedList<E> concatenated = new LinkedList<E>();
	return ;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//
//    public boolean contains(E e) {
//        if (e == get(size() - 1)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public LinkedList<E> concatenate(LinkedList<E> lst) {
//        LinkedList<E> concatenatedList = new LinkedList<E>();
//        concatenatedList.reverse(this.first);
//        concatenatedList.addLast(lst);
//        return concatenatedList;
//    }
//
//    private void concatenate(Node<E> n) {
//        if (n != null) {
//            this.addLast(n.elem);
//            this.clone(n.next);
//        }
//    }

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

    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

}
