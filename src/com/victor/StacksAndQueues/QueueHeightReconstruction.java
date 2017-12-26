package com.victor.StacksAndQueues;

/**
 * Created by Victor on 12/26/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h is the height of the person and k
 * is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * <p>
 * Solution:
 * People are only counting (in their k-value) taller or equal-height others standing in front of them.
 * So a smallest person is completely irrelevant for all taller ones. And of all smallest people,
 * the one standing most in the back is even completely irrelevant for everybody else. Nobody is counting that person.
 * So we can first arrange everybody else, ignoring that one person. And then just insert that person appropriately.
 * Now note that while this person is irrelevant for everybody else, everybody else is relevant for this person
 * - this person counts exactly everybody in front of them. So their count-value tells you exactly the index they must be standing.
 * So you can first solve the sub-problem with all but that one person and then just insert that person appropriately.
 * And you can solve that sub-problem the same way, first solving the sub-sub-problem with all but the
 * last-smallest person of the subproblem. And so on. The base case is when you have the sub-...-sub-problem of zero people.
 * You're then inserting the people in the reverse order, i.e., that overall last-smallest person in the very end
 * and thus the first-tallest person in the very beginning. That's what the above solution does, Sorting the people from the
 * first-tallest to the last-smallest, and inserting them one by one as appropriate.
 */

public class QueueHeightReconstruction {

    public int[][] reconstructQueue(int[][] people) {

        ArrayList<Person> queList = new ArrayList<>();
        for (int i = 0; i < people.length; i++)
            queList.add(new Person(people[i][0], people[i][1]));

        Collections.sort(queList);

        ArrayList<Person> sortedQue = new ArrayList<>();

        for (Person p : queList)
            sortedQue.add(p.k, p);

        int[][] resultArray = new int[people.length][2];

        for (int i = 0; i < people.length; i++) {
            resultArray[i][0] = sortedQue.get(i).h;
            resultArray[i][1] = sortedQue.get(i).k;
        }

        return resultArray;
    }

    class Person implements Comparable<Person> {

        int h;
        int k;

        public Person(int h, int k) {
            this.h = h;
            this.k = k;
        }

        @Override
        public int compareTo(Person o) {
            int personH = o.h;
            int personK = o.k;
            int difference = personH - h;

            return difference == 0 ? k - personK : difference;
        }

        @Override
        public String toString() {
            return "[" + h + "," + k + "]";
        }
    }
}
