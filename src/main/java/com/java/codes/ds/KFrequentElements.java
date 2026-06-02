package com.java.codes.ds;

import java.util.*;

public class KFrequentElements {

    private int[] sorting(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        System.out.println(Arrays.deepToString(arr.toArray()));

        return res;
    }

    private int[] minHeap(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();
        int[] res = new int[k];

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {

            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }

        return res;
    }


    /*
    Input: nums = [1,1,1,2,2,3], k = 2

    Step 1: count = {1:3, 2:2, 3:1}

    Step 2-3: freq array
    freq[0] = []
    freq[1] = [3]
    freq[2] = [2]
    freq[3] = [1]
    freq[4] = []
    freq[5] = []
    freq[6] = []

    Step 5: Loop from index 6 down to 1
    i=6: freq[6] is empty
    i=5: freq[5] is empty
    i=4: freq[4] is empty
    i=3: res.addAll(freq[3]) → res = [1]
    i=2: res.addAll(freq[2]) → res = [1, 2] → size == k, return

    Output: [1, 2]
    */

    private int[] bucketSort(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();
        int[] res = new int[k];

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;

        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int num : freq[i]) {
                res[index] = num;
                index++;
                if (index == k)
                    return res;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 0, 8, 9, 9, 2, 2, 3, 13, 13};
        int k = 2;
        KFrequentElements kFrequentElements = new KFrequentElements();
        System.out.println(" sorted elements are " + Arrays.toString(kFrequentElements.sorting(nums, k)));
        System.out.println(" bucket sort -> sorted elements are " + Arrays.toString(kFrequentElements.bucketSort(nums, k)));
    }
}
