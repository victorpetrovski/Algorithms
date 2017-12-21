package com.victor.bitmanipulation;

/**
 * Created by Victor on 12/21/17.
 */
public class MaximizingXOR {


    /**
     * Given two integers, L and R, find the maximal value of A xor B, where A and B satisfy the following condition:
     * <p>
     * L < A < B < R
     */
    public void findMaxXorInRange(int leftRange, int rightRange) {
        int max = Integer.MIN_VALUE;
        for (int A = leftRange; A <= rightRange; A++) {
            for (int B = leftRange; B <= rightRange; B++) {
                int current = A ^ B;
                if (current > max)
                    max = current;

            }
        }
        System.out.println("Max is: " + max);
    }
}
