package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<I> implements Iterable<I> {
    private Node<I> first;
    private Node<I> last;
    private int n;

    private static class Node<I> {
        private I item;
        private Node<I> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public I peek() {
        if (isEmpty()) throw new NoSuchElementException("Cola sin elementos");
        return first.item;
    }

    public void enqueue(I item) {
        Node<I> oldlast = last;
        last = new Node<I>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public I dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Cola sin elementos");
        I item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null; 
        return item;
    }


    public Iterator<I> iterator()  {
        return new LinkedIterator(first);  
    }

    private class LinkedIterator implements Iterator<I> {
        private Node<I> current;

        public LinkedIterator(Node<I> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public I next() {
            if (!hasNext()) throw new NoSuchElementException();
            I item = current.item;
            current = current.next; 
            return item;
        }
    }

}