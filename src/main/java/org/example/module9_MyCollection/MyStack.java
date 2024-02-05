package org.example.module9_MyCollection;

import java.util.Arrays;
import java.util.Objects;

public class MyStack<T> implements MyCollection<T>{
    public static final int DEFAULT_CAPACITY = 8;
    private T[] array;
    private int top;

    public MyStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public MyStack(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

    public void add(T value) {
        if (top + 1 >= array.length) {
            array = Arrays.copyOf(array, top + top);
        }
        array[++top] = value;
    }

    public void remove(int index) {
        Objects.checkIndex(index, top + 1);

        for (int i = index; i < top; i++) {
            array[i] = array[i + 1];
        }

        if (top == array.length) {
            array[top] = null;
        }

        top--;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < top + 1; i++) {
            array[i] = null;
        }
        top = -1;
        if (array.length > DEFAULT_CAPACITY) {
            array = (T[]) new Object[DEFAULT_CAPACITY];
        }
    }

    public T peek() {
        if (top == -1) throw new NullPointerException();

        return array[top];
    }

    public T pop() {
        if (top == -1) throw new NullPointerException();

        T temp = array[top];
        array[top] = null;
        top--;
        return temp;
    }
}
