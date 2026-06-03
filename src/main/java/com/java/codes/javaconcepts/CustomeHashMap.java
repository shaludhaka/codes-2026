package com.java.codes.javaconcepts;

import java.security.Key;

public class CustomeHashMap<K, V> {

    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 32;

    public Entry[] hashtable;

    public CustomeHashMap() {
        hashtable = new Entry[INITIAL_SIZE];
    }

    public CustomeHashMap(int maxCapacity) {
        int size = tableSizeFor(maxCapacity);
        hashtable = new Entry[size];

    }

    //TODO: understand
    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

    public void put(K key, V value) {

        int hashCode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hashCode];
        if (node == null) {
            node = new Entry(key, value);
            hashtable[hashCode] = node;
        } else {
            while (node.next != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                } else {
                    node = node.next;
                }
            }
            Entry newNode = new Entry(key, value);
            node.next = newNode;
        }
    }

    public V get(K k) {
        int index = k.hashCode() % hashtable.length;

        Entry node = hashtable[index];

        while (node != null) {
            if (node.key == k) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    public static void main(String[] args) {
        CustomeHashMap<Integer, String> customeHashMap = new CustomeHashMap<>(7);
        customeHashMap.put(1, "first");
        customeHashMap.put(2, "second");
        customeHashMap.put(3, "third");
        customeHashMap.put(4, "fourth");
        customeHashMap.put(5, "fifth");
        customeHashMap.put(6, "sixth");
        customeHashMap.put(7, "seventh");
        customeHashMap.put(8, "eigth");

        String value = customeHashMap.get(8);
        System.out.println(value);
    }
}
