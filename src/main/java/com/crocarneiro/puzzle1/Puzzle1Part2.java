package com.crocarneiro.puzzle1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle1Part2 {
    public static void main(String[] args) {
        var file = new File("input.txt");
        try (var inputStream = Puzzle1.class.getResourceAsStream("input.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String item;
            List<Long> inventory = new ArrayList<>();
            var caloriesSum = 0L;
            while((item = bufferedReader.readLine()) != null) {
//                System.out.println(item);
                if(item.isBlank()) {
                    inventory.add(caloriesSum);
                    caloriesSum = 0;
                } else {
                    caloriesSum += Long.parseLong(item);
                }
            }
            inventory.add(caloriesSum);

            bufferedReader.close();

            Collections.sort(inventory);
//            inventory.stream().forEach(System.out::println);
//            System.out.println("\n\n");
            Collections.reverse(inventory);
//            inventory.stream().forEach(System.out::println);
//            System.out.println("\n\n");

            var sublist = inventory.subList(0, 3);
            sublist.stream().forEach(System.out::println);
            System.out.println("\n\n");
            var sum = sublist.stream().reduce(0L, Long::sum);

            System.out.println("Sum => " + sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
