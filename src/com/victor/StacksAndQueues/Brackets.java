package com.victor.StacksAndQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Victor on 1/21/18.
 *
 * Codility test
 *
 *A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

 S is empty;
 S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 S has the form "VW" where V and W are properly nested strings.
 For example, the string "{[()()]}" is properly nested but "([)()]" is not.

 Write a function:

 class Solution { public int solution(String S); }

 that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

 For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

 Assume that:

 N is an integer within the range [0..200,000];
 string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N) (not counting the storage required for input arguments)
 *
 */
public class Brackets {

    private static final int PROPERLY_NESTED = 1;
    private static final int WRONGLY_NESTED = 0;


    ArrayList<Character> openBracketList = new ArrayList<Character>();
    ArrayList<Character> closedBracketList = new ArrayList<Character>();

    public int solution(String S) {
        // write your code in Java SE 8
        openBracketList.add('(');
        closedBracketList.add(')');

        openBracketList.add('[');
        closedBracketList.add(']');

        openBracketList.add('{');
        closedBracketList.add('}');


        LinkedStack<Character> bracketStack = new LinkedStack<>();

        //S is empty;
        if(S.isEmpty()) return PROPERLY_NESTED;

        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);

            //If we find open bracket push it into stack
            if(openBracketList.contains(currentChar)){
                bracketStack.push(currentChar);


            }else if(closedBracketList.contains(currentChar)){
                if(bracketStack.isEmpty())
                    return WRONGLY_NESTED;
                //We found a closed bracket, check if it matches the last open bracket
                // pop the stack and continue
                if(!doesBracketMatch(bracketStack.pop(),currentChar))
                    return WRONGLY_NESTED;
            }
        }

        return  bracketStack.isEmpty() ? PROPERLY_NESTED : WRONGLY_NESTED;
    }

    private boolean doesBracketMatch(Character open, Character closed){
        int indexOfOpen =  openBracketList.indexOf(open);
        return  closedBracketList.get(indexOfOpen) == closed;
    }

    class SLLNode<E> {

         public E element;

         public SLLNode<E> succ;

        public SLLNode(E elem,SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    class LinkedStack<E> implements Stack<E> {

        //Stekot e pretstaven na sledniot nacin: top e link do prviot jazol
        // na ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
        private SLLNode<E> top;

        public LinkedStack() {
            // Konstrukcija na nov, prazen stek.
            top = null;
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (top == null);
        }

        public E peek() {
            // Go vrakja elementot na vrvot od stekot.
            if (top == null)
                throw new NoSuchElementException();
            return top.element;
        }

        public void clear() {
            // Go prazni stekot.
            top = null;
        }

        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            top = new SLLNode<E>(x, top);
        }

        public E pop() {
            // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
            if (top == null)
                throw new NoSuchElementException();
            E topElem = top.element;
            top = top.succ;
            return topElem;
        }
    }

    interface Stack<E> {

        // Elementi na stekot se objekti od proizvolen tip.

        // Metodi za pristap:

        public boolean isEmpty ();
        // Vrakja true ako i samo ako stekot e prazen.

        public E peek ();
        // Go vrakja elementot na vrvot od stekot.

        // Metodi za transformacija:

        public void clear ();
        // Go prazni stekot.

        public void push (E x);
        // Go dodava x na vrvot na stekot.

        public E pop ();
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
    }

}


