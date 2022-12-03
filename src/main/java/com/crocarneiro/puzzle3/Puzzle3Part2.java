package com.crocarneiro.puzzle3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Puzzle3Part2 {
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
            var counter = 0;
            String[] group = new String[3];
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line + " | " + counter);
                String badge = null;
                group[counter] = line;
                if(counter == 2) {
                    for(var i = 0; i < group[0].length(); i++) {
                        var c = group[0].charAt(i);
                        if(group[1].indexOf(c) > -1 && group[2].indexOf(c) > -1) {
                            System.out.println("Badge => " + c);
                            badge = "" + c;
                            break;
                        }
                    }

                    if(badge == null) throw new RuntimeException("Badge not found!");
                    totalPriority += priorities.get(badge);

                    counter = 0;
                    group = new String[3];
                } else {
                    counter++;
                }
            }

            System.out.println("Total priority = " + totalPriority);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
