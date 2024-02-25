package org.example.module10_Files.task1_;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Demo1 {
    private static final String filePath = "src\\main\\java\\org\\example\\module10_Files\\task1_\\file.txt";
    public static void main(String[] args) {
        // Just for creating a file:
//        File file = new File(filePath);
//
//        try (FileWriter fileWriter = new FileWriter(file)) {
//
//        } catch(IOException e) {
//            throw new RuntimeException(e);
//        }
        validatePhoneNumbers(filePath);
    }

    public static void validatePhoneNumbers(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(Demo1::validateAndPrintPhoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void validateAndPrintPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("(\\(\\d{3}\\) \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("Phone number: " + phoneNumber);
        }
    }
}
