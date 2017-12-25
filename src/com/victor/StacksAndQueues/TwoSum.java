package com.victor.StacksAndQueues;

import java.util.HashMap;

/**
 * Created by Victor on 12/25/17.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mapValues = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //if the number in the array is bigger than the target we don't need to compare it
            if (mapValues.containsKey(nums[i])) {
                return new int[]{mapValues.get(nums[i]), i};
            }

            mapValues.put(target - nums[i], i);

        }

        return new int[]{0, 0};
    }
}
