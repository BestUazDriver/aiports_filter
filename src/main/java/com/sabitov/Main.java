package com.sabitov;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    void reader(int column, String str) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "airports.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr[column - 1].replace("\"", "").startsWith(str))
                    System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Invalid column number");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Column: ");
        int i = scanner.nextInt();
        System.out.println("Line: ");
        String str = scanner.next();
        new Main().reader(i, str);
    }
}
