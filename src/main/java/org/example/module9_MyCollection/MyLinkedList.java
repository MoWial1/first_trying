package org.example.module9_MyCollection;

import java.util.Objects;

public class MyLinkedList<T> implements MyCollection<T>{
    private int size;
    private Node<T> head;
    private Node<T> tail;

    {
        head = null;
        tail = null;
    }

    public void add(T value) {
        Node<T> temp = new Node<>(value);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
        size++;
    }

    // begin remove methods
    public void remove(int index) {
        Objects.checkIndex(index, size);

        /*
        Потрібно перевіряти індекс на перший або останній елемент,
        бо в методі removeFromInside при видаленні елемента, потрібні його сусіди,
        які в свою чергу не можуть бути null
        */
        if (index == 0) {
            Node<T> temp = head.next;
            temp.previous = null;
            head = temp;

        } else if (index == size - 1) {
            Node<T> temp = tail.previous;
            temp.next = null;
            tail = temp;

        } else if (size > 10) {
            if (index <= size / 2) {
                removeFromHead(index);
            } else {
                removeFromTail(index);
            }
        } else {
            removeFromHead(index);
        }

        size--;
    }

    private void removeFromHead(int index) {
        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        removeFromInside(node);
    }
    private void removeFromTail(int index) {
        Node<T> node = tail;

        for (int i = size - 1; i > index; i--) {
            node = node.previous;
        }
        removeFromInside(node);
    }

    private void removeFromInside(Node<T> nodeToRemove) {
        if (nodeToRemove == null) throw new NullPointerException();
        Node<T> temp1 = nodeToRemove.next;
        Node<T> temp2 = nodeToRemove.previous;

        temp1.previous = temp2;
        temp2.next = temp1;
        nodeToRemove = null;
    }
    // end remove methods


    // begin get methods
    public T get(int index) {
        Objects.checkIndex(index, size);

        if (size > 9 && index > size / 2) {
            return getFromTail(index);
        }
        return getFromHead(index);
    }
    private T getFromHead(int index) {
        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.getData();
    }
    private T getFromTail(int index) {
        Node<T> node = tail;

        for (int i = size - 1; i > index; i--) {
            node = node.previous;
        }
        return node.getData();
    }
    // end get methods



    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if (size == 0) throw new NullPointerException();
        Node<T> node = head;

        while(node.next == null) {
            node = node.next;
            node.previous = null;
        }

        node = null;
        size = 0;
    }

    private class Node<T> {
        private T data;
        public T getData() { return data; }

        public Node(T data) {
            this.data = data;
            next = null;
            previous = null;
        }

        public Node<T> next;
        public Node<T> previous;
    }
}
