package com.crocarneiro.puzzle3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Puzzle3 {
    public static void main(String[] args) {
        var priorities = new HashMap<String, Integer>();

        for(int c = 'a', C = 'A', i = 1, j = 27;
            c <= 'z' && C <= 'Z' && i <= 26 && j <= 52;
            c++, C++, i++, j++
        ) {
            //System.out.println("" + c + " = " + i + " | " + C + " = " + j);
            priorities.put("" + (char) c, i);
            priorities.put("" + (char) C, j);
        }

        try(var inputStream = Puzzle3.class.getResourceAsStream("input.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            var totalPriority = 0;
            while((line = bufferedReader.readLine()) != null) {
                var halfPoint = line.length() / 2;
                var firstHalf = line.substring(0, halfPoint);
                var secondHalf = line.substring(halfPoint, line.length());

                var repeatedItemType = "";
                for (var i = 0; i < secondHalf.length(); i++) {
                    var c = secondHalf.charAt(i);
                    if(firstHalf.indexOf(c) > -1) {
                        repeatedItemType = "" + c;
                    }
                }

                var priority = priorities.get(repeatedItemType);
                totalPriority += priority;

                System.out.println(line + " | " + firstHalf + " | " + secondHalf + " | " + repeatedItemType + " | " + priority);
            }

            System.out.println("Total priority = " + totalPriority);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}