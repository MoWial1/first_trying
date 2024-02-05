package org.example.module9_MyCollection;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyQueue<Integer> myQueue = new MyQueue<>();
        MyStack<Integer> myStack = new MyStack<>();
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();


        //- ArrayList - - - - - - - - - - - - - - - - - - - -
       for (int i = 1; i < 20; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            //System.out.print(arrayList.get(i) + " ");
        }
        // - - - - - - - - - - - - - - - - - - - - - - -
        // - Queue - - - - - - - - - - - - - - - - - - - -
        for (int i = 1; i < 20; i++) {
            myQueue.add(i);
        }

        for (int i = 0; i < myQueue.size(); i++) {
            //System.out.print(myQueue.poll() + " ");
        }
        //System.out.println();
        // - - - - - - - - - - - - - - - - - - - - - - -
        // - Stack - - - - - - - - - - - - - - - - - - - -
        for (int i = 1; i < 20; i++) {
            myStack.add(i);
        }

        //System.out.println(myStack.size());

        myStack.remove(10);
        int size = myStack.size();

        for (int i = 0; i < size; i++) {
            //System.out.print(myStack.pop() + " ");
        }
        System.out.println();
        System.out.println();
        // - - - - - - - - - - - - - - - - - - - - - - -
        // - HashMap - - - - - - - - - - - - - - - - - - - -
        for (int i = 1; i < 10; i++) {
            hashMap.put(i, "value" + i);
        }
        for (int i = 100; i < 200; i += 11) {
            hashMap.put(i, "value" + i);
        }

        hashMap.remove(2);
        hashMap.remove(166);

        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(9));
        System.out.println(hashMap.get(166));
        System.out.println(hashMap.get(133));
        // - - - - - - - - - - - - - - - - - - - - - - -
    }
}
