package com.sabitov.conf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Conf {

    private int column;
    private final String configFilePath = "src/main/resources/config/conf.yaml";

    public Conf() {
        BufferedReader confReader;
        try {
            confReader = new BufferedReader(new FileReader(configFilePath));
            String line;
            while ((line = confReader.readLine()) != null) {
                if (line.startsWith("column")) {
                    String[] arr = line.split(" : ");
                    this.column = Integer.parseInt(arr[1]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Config file not found");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int getColumn() {
        return column;
    }
}
