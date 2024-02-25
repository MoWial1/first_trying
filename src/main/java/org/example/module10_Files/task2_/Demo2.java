package org.example.module10_Files.task2_;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;

public class Demo2 {
    public static final String pathToTxtFile = "src\\main\\java\\org\\example\\module10_Files\\task2_\\file.txt";
    public static final String pathToJsonFile = "D:\\GoIT\\GoIT_Project\\src\\main\\java\\org\\example\\module10_Files\\task2_\\user.json";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(pathToTxtFile);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        reader.read();
        reader.print();

        try (FileWriter fileWriter = new FileWriter(pathToJsonFile)) {
            gson.toJson(reader.getUsers(), fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
