package org.example.module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FizzBuzz {
    private int n;
    private BlockingQueue<String> queueResources;
    private int i;

    {
        queueResources = new LinkedBlockingDeque<>();
        i = 1;
    }
    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while(i <= n) {
            if(i % 3 == 0 && i % 5 !=0) {
                queueResources.add("fizz");
                i++;
                notifyAll();

                //System.out.println("fizz() if " + i);
            } else {
                //System.out.println("fizz() else " + i);
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while(i <= n) {
            if(i % 3 != 0 && i % 5 ==0) {
                queueResources.add("buzz");
                i++;
                notifyAll();

                //System.out.println("buzz() if " + i);
            } else {
                //System.out.println("buzz() else" + i);
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while(i <= n) {
            if(i % 15==0) {
                queueResources.add("fizzbuzz");
                i++;
                notifyAll();

                //System.out.println("fizzbuzz() if " + i);
            } else {
                //System.out.println("fizzbuzz() else" + i);
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while(i <= n) {
            if(i % 3 != 0 && i % 5 !=0) {
                System.out.println(i);
                i++;
                //System.out.println("number() if " + i);
                notifyAll();
            } else {
                wait();
            }


            if (!queueResources.isEmpty()) {
                //System.out.println("number() else" + i);
                System.out.println(queueResources.poll());
            }
        }
    }



}
