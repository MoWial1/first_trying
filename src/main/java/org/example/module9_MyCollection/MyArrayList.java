package org.example.module9_MyCollection;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements MyCollection {
    public static final int DEFAULT_CAPACITY = 8;
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public MyArrayList(int size) {
        array = (T[]) new Object[size];
        this.size = 0;
    }

    public void add(T value) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, size + size);;
        }
        array[size++] = value;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        if (size == array.length) {
            array[size - 1] = null;
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        if (array.length > DEFAULT_CAPACITY) {
            array = (T[]) new Object[DEFAULT_CAPACITY];
        }
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }

}
