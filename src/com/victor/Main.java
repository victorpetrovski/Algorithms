package com.victor;

import com.victor.StacksAndQueues.QueueHeightReconstruction;
import com.victor.StacksAndQueues.TwoSum;
import com.victor.bitmanipulation.CounterGamePowerOfTwo;
import com.victor.matrix.RotateMatrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Test your solution here
        QueueHeightReconstruction queueHeightReconstruction = new QueueHeightReconstruction();
        queueHeightReconstruction.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }


    private static void printArray(int[] anArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(anArray[i]);
        }
        System.out.println(sb.toString());
    }

    public void swap(int a[], int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public int removeElement(int[] nums, int val) {
        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                newLength++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                continue;

            for (int j = nums.length - 1; j >= 0; j--) {
                if (i >= j) {
                    return newLength;
                }
                if (nums[j] != val) {
                    swap(nums, i, j);
                    i = 0;
                    break;
                }

            }
        }
        return newLength;
    }

    private static boolean areAnagrams(String stringA, String stringB) {
        if (stringA.length() != stringB.length()) return false;

        int lenth = stringA.length();

        int value = 0;

        for (int i = 0; i < lenth; i++) {
            value ^= stringA.charAt(i);
            value ^= stringB.charAt(i);
        }

        return value == 0;
    }

    private static int charUnpaired(String str) {
        int initValue = 0;

        for (char i : str.toCharArray()) {
            initValue ^= (i - 'a');
        }
        return initValue;
    }

    private static int charUnpaired(int[] str) {
        int initValue = 0;

        for (int i : str) {
            initValue ^= i;
        }
        return initValue;
    }

    private static boolean areAllCharactersUniquetwo(String string) {
        System.out.println("Checkging string: ");
        int initValue = 0;

        for (Character i : string.toCharArray()) {
            initValue ^= i;
        }
        return initValue == 0;
    }

    private static boolean areAllCharactersUnique(String string) {
        System.out.println("Checkging string: ");
        int initValue = 0;

        for (Character c : string.toCharArray()) {
            int charval = c - 'a' + 1;
            if ((initValue & (1 << charval)) > 0) return false;
            initValue |= (1 << charval);
        }

        return true;
    }

    private static void replaceString(char[] str, int length) {
        int spaceCount = 0, newLength, i = 0;

        for (int j = 0; j < length; j++) {
            if (str[j] == ' ') spaceCount++;
        }

        newLength = length + (spaceCount * 2);

        str[newLength] = '\0';
    }

}
