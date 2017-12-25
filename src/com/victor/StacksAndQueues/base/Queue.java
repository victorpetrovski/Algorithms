package com.victor.StacksAndQueues.base;

public interface Queue<E> {

    public boolean isEmpty();

    public int size();

    public E peek();

    public void clear();

    public void enqueue(E x);

    public E dequeue();

}