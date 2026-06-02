package com.java.codes.ds;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    void bruteforce(int[] arr) {
        HashSet<Integer> nums = new HashSet<>();
        for (int num : arr) {
            nums.add(num);
        }
        int max_len = 0;
        for (int num : nums) {

            int local_len = 1;
            int seq = num;

            while (nums.contains(seq + 1)) {
                seq++;
                local_len++;
            }
            if (local_len > max_len) {
                max_len = local_len;
            }
        }
        System.out.println(max_len);
    }

    void usingSorting(int[] arr) {

        int max_length = 0;

        if (arr.length == 0)
            return;

        Arrays.sort(arr);
        // 1,2,3,4,100,101,102,103,104,105
        //--> 0,1,1,2
        //1,1,2,2,3,3,100,101,102

        int last_smallest = Integer.MIN_VALUE;

        int local_len = 1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] - 1 == last_smallest) {
                local_len++;
                last_smallest = arr[i];
            } else if (arr[i] != last_smallest) {
                local_len = 1;
                last_smallest = arr[i];
            }

            max_length = Math.max(local_len, max_length);
        }

        System.out.println(max_length);


    }

    void usingHashSet(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        // 100,4,200,2,3,1

        for (int num : arr) {
            set.add(num);
        }
        int max_length = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int seq = num;
                int local_len = 1;
                while (set.contains(seq + 1)) {
                    seq++;
                    local_len++;
                }
                max_length = Math.max(max_length, local_len);
            }
        }
        System.out.println(max_length);

    }

    public static void main(String[] args) {

        // Brute force O(n^2)
        int[] arr = {1, 0, 1, 2};
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        lcs.bruteforce(arr);

        //using sorting technique O(nlogn)
        lcs.usingSorting(arr);

        // using O(n)
        lcs.usingHashSet(arr);

    }
}
