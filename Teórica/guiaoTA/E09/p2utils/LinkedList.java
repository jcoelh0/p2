package p2utils;

public class LinkedList<E> {

   /**
    * {@code LinkedList} constructor, empty so far.
    */
   public LinkedList() { }

   /**
    * @return Number of elements in the list
    */
   public int size() { return size; }

   /**
    * Checks if the list is empty
    * @return  {@code true} if list empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return size == 0; }

   /**
    * @return  First element in the list
    */
   public E first() {
      assert !isEmpty(): "empty!";

      return first.elem;
   }

   /**
    * @return  Last element in the list
    */
   public E last() {
      assert !isEmpty(): "empty!";
 
      return last.elem;
   }

   /**
    * Adds a new element to the start of the list
    */
   public void addFirst(E e) {
      first = new Node<>(e, first);
      if (isEmpty())
         last = first;
      size++;

      assert !isEmpty() && first().equals(e);
   }

   /**
    * Adds a new element to the end of the list
    */
   public void addLast(E e) {
      Node<E> newest = new Node<>(e);
      if (isEmpty())
         first = newest;
      else
         last.next = newest;
      last = newest;
      size++;

      assert !isEmpty() && last().equals(e);
   }

   /**
    * Removes the first element in the list
    */
   public void removeFirst() {
      assert !isEmpty(): "empty!";
      first = first.next;
      size--;
      if (isEmpty())
         last = null;
   }

   public String toString() {
      if (size()==0) 
         return "[ ]";
      String s = "[ " + first.elem.toString();
      if (size()==1) 
         return s + " ]";
      Node<E> n = first.next;
      while (n!=null) {
         s += ("," + n.elem.toString());
         n = n.next;
      }
      return s + " ]";
   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

}


