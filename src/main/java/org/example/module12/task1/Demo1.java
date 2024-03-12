package org.example.module12.task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Demo1 {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();

        Thread timeThread = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                showCurrentTime();
            }

        });

        Thread fiveSecondThread = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                showMessage5second();
            }

        });

        timeThread.start();
        fiveSecondThread.start();
    }

    private static void showCurrentTime() {
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String elapsedTime = currentTime.format(dateTimeFormatter);

        System.out.println("Elapsed time: " + elapsedTime);
    }

    private static void showMessage5second() {
        System.out.println("Минуло 5 секунд");
    }
}
