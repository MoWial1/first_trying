package org.example.module12.task2;

public class Demo2 {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(30);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //threadA.setPriority(2);

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //threadB.setPriority(2);

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //threadC.setPriority(1);

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //threadD.setPriority(3);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
