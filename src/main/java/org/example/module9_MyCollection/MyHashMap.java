package org.example.module9_MyCollection;

import java.util.Arrays;

public class MyHashMap<K extends Comparable<?>, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "key = " + key + ", value = " + value;
        }
    }

    private Entry<K, V>[] buckets;
    public static final int DEFAULT_SIZE = 8;
    private int size;

    {
        buckets = new Entry[DEFAULT_SIZE];
    }


    public void put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        if (findEntryByKey(key) != null) throw new IllegalArgumentException("Key already exists");

        int index = getIndex(key);
        Entry<K, V> entry = new Entry<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = entry;
        } else {
            Entry<K, V> temp = buckets[index];

            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = entry;
        }

        if (size > (buckets.length * 3) / 4) {
            buckets = Arrays.copyOf(buckets, size * 2);
        }
        size++;
    }

    public void remove(K key) {
        if (key == null) throw new NullPointerException();

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;

            if (buckets[i].key.equals(key)) {
                if (buckets[i].next == null) {
                    buckets[i] = null;
                } else {
                    buckets[i] = buckets[i].next;
                }
                size--;
                return;

            } else {
                Entry<K, V> current = buckets[i];
                Entry<K, V> previous = null;

                while (current != null) {
                    if (current.key.equals(key)) {
                        previous.next = current.next;
                        current = null;

                        size--;
                        return;
                    }

                    previous = current;
                    current = current.next;
                }

            }
        }
    }

    public V get(K key) {
        if (key == null) throw new NullPointerException();

        Entry<K, V> current = findEntryByKey(key);

        if (current == null) {
            return null;
        }
        return current.value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            buckets[i] = null;
        }
        size = 0;
        if (buckets.length > DEFAULT_SIZE) {
            buckets = new Entry[DEFAULT_SIZE];
        }
    }



    private Entry<K, V> findEntryByKey(K key) {
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] == null) continue;

            if(buckets[i].key.equals(key)) {
                return buckets[i];
            } else {
                Entry<K, V> current = buckets[i];

                while(current.next != null) {
                    current = current.next;

                    if (current.key.equals(key)) {
                        return current;
                    }
                }
            }
        }

        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }
}
