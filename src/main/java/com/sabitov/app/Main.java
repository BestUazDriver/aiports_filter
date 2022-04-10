package com.sabitov.app;

import com.sabitov.conf.Conf;
import com.sabitov.filter.Filter;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Line: ");
        String str = scanner.next();
        Conf conf = new Conf();
        Filter filter = new Filter();
        List<String> filteredAirports = filter.filter(conf.getColumn(), str);
        for (String airPort : filteredAirports) {
            System.out.println(airPort);
        }
    }
}
