package com.victor.StacksAndQueues;

import com.victor.StacksAndQueues.base.LinkedStack;
import com.victor.StacksAndQueues.base.Stack;

/**
 * Created by Victor on 12/25/17.
 */
public class SortStack<E extends Comparable> {

    public LinkedStack<E> sortStack(LinkedStack<E> stack) {
        LinkedStack<E> newStack = new LinkedStack<>();

        while (!stack.isEmpty()) {
            E topEelement = stack.pop();
            while (!newStack.isEmpty() && newStack.peek().compareTo(topEelement) > 0) {
                stack.push(newStack.pop());
            }
            newStack.push(topEelement);
        }
        return newStack;
    }
}
