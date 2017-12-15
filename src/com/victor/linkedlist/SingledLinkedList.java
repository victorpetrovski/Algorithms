package com.victor.linkedlist;

/**
 * Created by Victor on 12/15/17.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingledLinkedList<E> {
    private Node<E> first;

    public SingledLinkedList() {
        // Construct an empty SingledLinkedList
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            Node<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            Node<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        Node<E> ins = new Node<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, Node<E> node) {
        if (node != null) {
            Node<E> ins = new Node<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Node is null");
        }
    }

    public void insertBefore(E o, Node<E> before) {

        if (first != null) {
            Node<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                Node<E> ins = new Node<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Element does not exist");
            }
        } else {
            System.out.println("List is empty");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            Node<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            Node<E> ins = new Node<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            Node<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("List is empty");
            return null;
        }
    }

    public E delete(Node<E> node) {
        if (first != null) {
            Node<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Element does not exist");
                return null;
            }
        } else {
            System.out.println("List is empty");
            return null;
        }

    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> find(E o) {
        if (first != null) {
            Node<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Element does not exist");
            }
        } else {
            System.out.println("List is empty");
        }
        return first;
    }


    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            Node<E> tmp = first;
            Node<E> newsucc = null;
            Node<E> next;

            while (tmp != null) {
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }

    }

    public void merge(SingledLinkedList<E> in) {
        if (first != null) {
            Node<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    /**
     * Iterator class for iterating through the elements in the list
     */

    public Iterator<E> iterator() {
        // Return an iterator that visits all elements of this list, in left-to-right order.
        return new LRIterator<E>();
    }

    private class LRIterator<E> implements Iterator<E> {

        private Node<E> place, curr;

        private LRIterator() {
            place = (Node<E>) first;
            curr = null;
        }

        public boolean hasNext() {
            return (place != null);
        }

        public E next() {
            if (place == null)
                throw new NoSuchElementException();
            E nextElem = place.element;
            curr = place;
            place = place.succ;
            return nextElem;
        }

        public void remove() {
            //Not implemented
        }
    }
}
