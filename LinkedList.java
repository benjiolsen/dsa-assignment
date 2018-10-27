/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: LinkedList/ListNode
    PURPOSE: To act as the linked list data structure for the DSA Assignment.
             Stores generic objects in the nodes, being a doubly ended doubly
             linked list, so it also stores pointers to the tails and next and
             previous nodes in the list. An iterator is also implmented to
             iterate over the linked list.
    REFERENCES: Previously submitted by 19481681 Benjamin Olsen in previous
                practicals and assignments.
*/
import java.util.*;
public class LinkedList<E> implements Iterable<E>{
    private class ListNode<E>{// Private inner class
        public E value;
        public ListNode<E> next;
        public ListNode<E> prev;

        public ListNode(E inValue){
            // Sets the value, then sets the pointers to be null, as nothing
            // Exists there yet
            value = inValue;
            next = null;
            prev = null;
        }

        // Public setter functions
        public void setValue(E inValue){value = inValue;}
        public void setNext(ListNode<E> newNext){next = newNext;}
        public void setPrev(ListNode<E> newPrev){prev = newPrev;}

        // Public getter functions
        public E getValue(){return value;}
        public ListNode<E> getPrev(){return prev;}
        public ListNode<E> getNext(){return next;}
    }

    private class LinkedListIterator<E> implements Iterator<E>{
        // Private inner class
        private LinkedList<E>.ListNode<E> iterNext;

        // Iterates over the list starting at the start
        public LinkedListIterator (LinkedList<E> theList)
        {iterNext = theList.head;}

        public boolean hasNext(){return (iterNext != null);}

        public E next(){
            E value;
            if(iterNext == null){
                value = null;
            }
            else{
                // Returns the next, non null value, then iterates to the next
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove(){
            // Unsupported operation currently
            throw new UnsupportedOperationException("Not supported");
        }
    }
    // Returns the iterator
    public Iterator<E> iterator(){return new LinkedListIterator<E>(this);}

    // Private classfields
    private ListNode<E> head;
    private ListNode<E> tail;

    // Default constructor
    public LinkedList(){
        // Default is empty
        head = null;
        tail = null;
    }

    // Sets the front value to be the inserted value
    public void insertFirst(E newValue)
    {
        ListNode<E> newNd = new ListNode<E>(newValue);
        if(isEmpty()){
            // if the list is empty, the new value is the head AND the tail
            head = newNd;
            tail = newNd;
        }
        else{
            // If the list already has a head value, shift so it points to the
            // the new value, and let the new value point to it
            newNd.setNext(head);
            head.setPrev(newNd);
            head = newNd;

        }
    }

    // Sets the tail to be the inserted value
    public void insertLast(E newValue)
    {
        ListNode<E> newNd = new ListNode<E>(newValue);
        if(isEmpty()){
            // if the list is empty, the new value is the head AND the tail
            head = newNd;
            tail = newNd;
        }
        else{
            // Else, the new value points back to the old tail, and becomes the
            // new tail
            newNd.setPrev(tail);
            tail.setNext(newNd);
            tail = newNd;
        }
    }

    // Returns the front value without removing it
    public E peekFirst(){
        E nodeValue = null;
        if(isEmpty()){// Ensures the list isnt empty
            throw new IllegalArgumentException("The list is empty");
        }
        else{
            nodeValue = head.getValue();
        }
        return nodeValue;
    }

    // Returns the tail without removing it
    public E peekLast(){
        E nodeValue = null;
        if(isEmpty()){// Ensures the list isnt empty
            throw new IllegalArgumentException("The list is empty");
        }
        else{
            nodeValue = tail.getValue();
        }
        return nodeValue;
    }

    // Removes and returns the front value
    public E removeFirst()
    {
        E nodeValue = null;
        if(isEmpty()){
            throw new IllegalArgumentException("The list is empty");
        }
        else if(head.getNext() == null){
            // if the list is one in size, set everything to null
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else{
            // if the list is 2+ values, make sure to set the value after the
            // head to be the new head
            nodeValue = head.getValue();
            head = head.getNext();
            head.setPrev(null);
        }
        return nodeValue;
    }

    // Removes and returns the tail value
    public E removeLast(){
        E nodeValue = null;
        if(isEmpty()){
            throw new IllegalArgumentException("The list is empty");
        }
        else if(head.getNext() == null){
            // if the list is one in size, set everything to null
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else{
            // If the list is 2+ values, make sure to make the second last item
            // become the tail, and let it point to nothing
            ListNode<E> currNd = tail;
            ListNode<E> prevNd = tail.getPrev();

            prevNd.setNext(null);
            tail = prevNd;
            nodeValue = currNd.getValue();
        }
        return nodeValue;
    }

    // Public function to test if the list is empty
    public boolean isEmpty(){return (head == null);}
}
