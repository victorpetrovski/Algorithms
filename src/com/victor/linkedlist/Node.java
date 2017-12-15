package com.victor.linkedlist;

/**
 * Created by Victor on 12/15/17.
 */
public class Node<E> {

    protected E element;
    protected Node<E> succ;

    public Node(E elem, Node<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
