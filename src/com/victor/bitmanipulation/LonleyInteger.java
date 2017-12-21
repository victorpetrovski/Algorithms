package com.victor.bitmanipulation;

/**
 * Created by Victor on 12/16/17.
 * Consider an array of  integers, where all but one of the integers occur in pairs.
 * In other words, every element in  occurs exactly twice except for one unique element.
 * Given , find and print the unique element.
 * <p>
 * Sample input :
 * 0 0 1 2 1
 * Sample output:
 * 2
 */

public class LonleyInteger {

    public int findLonleyInteger(int[] numbers) {
        int lonleyInt = 0;

        for (int i = 0; i < numbers.length; i++) {
            lonleyInt ^= numbers[i];
        }

        return lonleyInt;
    }

    static int comparePoints(Integer aPoints, Integer bPoints) {
       return aPoints.compareTo(bPoints);
    }
}
