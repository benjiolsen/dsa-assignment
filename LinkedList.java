// Benjamin Olsen
// 19481681
// Acts as the linked list ADT for DSA
// Double ended, doubly linked, generic, with an iterator
import java.util.*;
public class LinkedList<E> implements Iterable<E>
{
    private class ListNode<E>
    {// private inner class
        public E value;
        public ListNode<E> next;
        public ListNode<E> prev;

        public ListNode(E inValue)
        {// sets the value, then sets the pointers to be null, as nothing
         // exists there yet
            value = inValue;
            next = null;
            prev = null;
        }

        public E getValue()
        {
            return value;
        }

        public void setValue(E inValue)
        {
            value = inValue;
        }

        public ListNode<E> getNext()
        {
            return next;
        }

        public void setNext(ListNode<E> newNext)
        {
            next = newNext;
        }

        public void setPrev(ListNode<E> newPrev)
        {
            prev = newPrev;
        }

        public ListNode<E> getPrev()
        {
            return prev;
        }
    }

    private class LinkedListIterator<E> implements Iterator<E>
    {// private inner class
        private LinkedList<E>.ListNode<E> iterNext;

        public LinkedListIterator (LinkedList<E> theList)
        {// Iterates over the list starting at the start
            iterNext = theList.head;
        }

        public boolean hasNext()
        {
            return (iterNext != null);
        }

        public E next()
        {
            E value;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {// Returns the next, non null value, then iterates to the next
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove()
        {// Unsupported operation currently
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private ListNode<E> head;
    private ListNode<E> tail;

    public LinkedList()
    {// Default is empty
        head = null;
        tail = null;
    }

    public void insertFirst(E newValue)
    {
        ListNode<E> newNd = new ListNode<E>(newValue);
        if(isEmpty())
        {// if the list is empty, the new value is the head AND the tail
            head = newNd;
            tail = newNd;
        }
        else
        {// If the list already has a head value, shift so it points to the
         // the new value, and let the new value point to it
            newNd.setNext(head);
            head.setPrev(newNd);
            head = newNd;

        }
    }

    public void insertLast(E newValue)
    {
        ListNode<E> newNd = new ListNode<E>(newValue);
        if(isEmpty())
        {// if the list is empty, the new value is the head AND the tail
            head = newNd;
            tail = newNd;
        }
        else
        {// Else, the new value points back to the old tail, and becomes the
         // new tail
            newNd.setPrev(tail);
            tail.setNext(newNd);
            tail = newNd;
        }
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public E peekFirst()
    {
        E nodeValue = null;
        if(isEmpty())
        {
            throw new IllegalArgumentException("The list is empty");
        }
        else
        {
            nodeValue = head.getValue();
        }

        return nodeValue;
    }

    public E peekLast()
    {
        E nodeValue = null;
        if(isEmpty())
        {
            throw new IllegalArgumentException("The list is empty");
        }
        else
        {
            nodeValue = tail.getValue();
        }

        return nodeValue;
    }

    public E removeFirst()
    {
        E nodeValue = null;
        if(isEmpty())
        {
            throw new IllegalArgumentException("The list is empty");
        }
        else if(head.getNext() == null)
        {// if the list is one in size, set everything to null
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {// if the list is 2+ values, make sure to set the value after the
         // head to be the new head
            nodeValue = head.getValue();
            head = head.getNext();
            head.setPrev(null);
        }
        return nodeValue;
    }

    public E removeLast()
    {
        E nodeValue = null;
        if(isEmpty())
        {
            throw new IllegalArgumentException("The list is empty");
        }
        else if(head.getNext() == null)
        {// if the list is one in size, set everything to null
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {// If the list is 2+ values, make sure to make the second last item
         // become the tail, and let it point to nothing
            ListNode<E> currNd = tail;
            ListNode<E> prevNd = tail.getPrev();

            prevNd.setNext(null);
            tail = prevNd;
            nodeValue = currNd.getValue();
        }

        return nodeValue;
    }

    public Iterator<E> iterator()
    {
        return new LinkedListIterator<E>(this);
    }
}
