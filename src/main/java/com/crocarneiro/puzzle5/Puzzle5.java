package com.crocarneiro.puzzle5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle5 {
    static Pattern cratePattern = Pattern.compile("\\[.\\]");

    public static void main(String[] args) {
        try(var inputStream = Puzzle5.class.getResourceAsStream("testInput.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            var linesStream = bufferedReader.lines();
            var linesList = linesStream.toList();
            bufferedReader.close();

            List<String> crates = new ArrayList<>();
            linesList.stream().forEach(line -> {
                var matcher = cratePattern.matcher(line);
                if(matcher.find())
                    crates.add(line);
            });
            Collections.reverse(crates);

            crates.stream().forEach(System.out::println);

//            String line;
//            while((line = bufferedReader.readLine()) != null) {
//                var matcher = cratePattern.matcher(line);
//
//                if(matcher.find()) {
//                    System.out.println(line);
//                }
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
