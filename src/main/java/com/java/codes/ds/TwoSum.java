package com.java.codes.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    int[] bruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    int[] twoPointerSorting(int[] nums, int target) {
        int out[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {

            out[i][0] = nums[i];
            out[i][1] = i;
        }

        int i = 0;
        int j = nums.length - 1;

        Arrays.sort(out, Comparator.comparingInt(a -> a[0]));
        while (i < j) {
            int sum = out[i][0] + out[j][0];
            if (sum == target) {
                return new int[]{
                        Math.min(out[i][1], out[j][1]),
                        Math.max(out[i][1], out[j][1])
                };
            } else if (sum < target) {
                i++;
            } else
                j--;
        }
        return new int[0];
    }

    int[] hashmap2pass(int[] nums, int target) {

        HashMap<Integer, Integer> valueIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            valueIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (valueIndex.containsKey(complement) && valueIndex.get(complement) != i) {
                return new int[]{i, valueIndex.get(complement)};
            }
        }
        return new int[0];
    }

    int[] hashmapSinglePass(int[] nums, int target) {

        HashMap<Integer, Integer> prevValueIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (prevValueIndex.containsKey(comp)) {
                return new int[]{prevValueIndex.get(comp), i};
            }
            prevValueIndex.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 3, 4, 5, 6};
        System.out.println("bruteforce two sum : " + Arrays.toString(twoSum.bruteForce(nums, 7)));
        System.out.println("twoPointerSorting two sum : " + Arrays.toString(twoSum.bruteForce(nums, 7)));
        System.out.println("hashmap2pass two sum : " + Arrays.toString(twoSum.bruteForce(nums, 7)));
        System.out.println("hashmapSinglePass two sum : " + Arrays.toString(twoSum.bruteForce(nums, 7)));
    }
}
