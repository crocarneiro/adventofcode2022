package com.crocarneiro.puzzle1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Puzzle1 {
    public static void main(String[] args) {
        try (var inputStream = Puzzle1.class.getResourceAsStream("input.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String item;
            List<Long> inventory = new ArrayList<>();
            var caloriesSum = 0L;
            while((item = bufferedReader.readLine()) != null) {
                if(item.isBlank()) {
                    inventory.add(caloriesSum);
                    caloriesSum = 0;
                } else {
                    caloriesSum += Long.parseLong(item);
                }
            }
            bufferedReader.close();

            var max = inventory.stream().max(Comparator.naturalOrder());
            System.out.println("Max => " + max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
