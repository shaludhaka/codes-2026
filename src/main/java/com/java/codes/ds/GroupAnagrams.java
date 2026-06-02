package com.java.codes.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    ArrayList<List<String>> sortingWay(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(str);
        }
        return new ArrayList<>(map.values());
    }

    ArrayList<List<String>> hashTableWay(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            int[] countArr = new int[26];
            for (char c : charArray) {

                countArr[c - 'a'] = countArr[c - 'a'] + 1;
            }
            String key = Arrays.toString(countArr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strings = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(groupAnagrams.sortingWay(strings));
        System.out.println(groupAnagrams.hashTableWay(strings));
    }
}
