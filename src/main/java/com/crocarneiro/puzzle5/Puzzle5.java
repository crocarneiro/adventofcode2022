package com.crocarneiro.puzzle5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

public class Puzzle5 {
    static Pattern cratePattern = Pattern.compile("\\[.\\]");

    public static void main(String[] args) {
        try(var inputStream = Puzzle5.class.getResourceAsStream("testInput.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while((line = bufferedReader.readLine()) != null) {
                var matcher = cratePattern.matcher(line);
                while(matcher.find()) {
                    System.out.println(matcher.group() + " ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
