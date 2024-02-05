package org.example.module9_MyCollection;

import java.util.Arrays;

public class MyQueue<T> implements MyCollection<T>{
    public static final int DEFAULT_CAPACITY = 8;
    private T[] array;
    private int size;
    private int head;

    public MyQueue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        head = 0;
    }
    public MyQueue(int size) {
        array = (T[]) new Object[size];
        this.size = 0;
    }

    public void add(T value) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, size + size);
        }
        array[size++] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = head; i < size + head; i++) {
            array[i] = null;
        }
        if (array.length > DEFAULT_CAPACITY) {
            array = (T[]) new Object[DEFAULT_CAPACITY];
        }
        size = 0;
        head = 0;
    }

    public T peek() {
        if (size == 0) throw new NullPointerException();
        return array[head];
    }

    public T poll() {
        if (size == 0) throw new NullPointerException();

        if (head >= size) {
            head = 0;
            size = 0;
            return null;
        }
        size--;
        return array[head++];
    }
}
