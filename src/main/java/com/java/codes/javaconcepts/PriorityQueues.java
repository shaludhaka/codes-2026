package com.java.codes.javaconcepts;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueues {

    void pq() {

    }

    public static void main(String[] args) {

        // min PQ
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(3);
        minPQ.add(4);
        minPQ.add(1);
        minPQ.add(10);

        minPQ.forEach((Integer val) -> System.out.println("min PQ " + val));

        //max PQ

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer a, Integer b) -> b - a);
        maxPQ.add(3);
        maxPQ.add(4);
        maxPQ.add(1);
        maxPQ.add(10);

        maxPQ.forEach(val -> System.out.println("max PQ " + val));

        while (!maxPQ.isEmpty()) {
            Integer val = maxPQ.poll();
        }

        int[] arr = {1, 2, 3, 4};
        Arrays.sort(arr);

        //Comparator comparable

        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog("GE", "ALISH");
        dogs[1] = new Dog("CE", "LALISH");
        dogs[2] = new Dog("FG", "KWALISH");

        Arrays.sort(dogs);

        //object sorting in possible through only comparator and comparable which helps in sorting

    }
}
