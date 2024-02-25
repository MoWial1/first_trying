package org.example.module10_Files.task2_;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    private List<User> users;
    private String filePath;

    public MyFileReader(String filePath) {
        this.filePath = filePath;
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void read() {
        try (FileReader fileReader = new FileReader(Demo2.pathToTxtFile)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // читаємо перший рядок ігноруючи його
            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\s+");

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        if (users == null) {
            throw new RuntimeException("You did not use method read");
        }
        users.stream().forEach(System.out::println);
    }
}
