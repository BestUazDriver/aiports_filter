package com.sabitov.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filter {

    private final String airportsCsvFilePath = "airports.csv";

    public List<String> filter(int column, String str) {

        List<String> airports = new ArrayList<>();
        BufferedReader airportsReader;

        try {
            airportsReader = new BufferedReader(new FileReader(airportsCsvFilePath));
            String line;

            while ((line = airportsReader.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr[column - 1].replace("\"", "").startsWith(str))
                    airports.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Airports file not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Invalid column number");
        }
        return airports;
    }
}
