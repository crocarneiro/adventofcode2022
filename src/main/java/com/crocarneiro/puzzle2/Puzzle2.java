package com.crocarneiro.puzzle2;

import com.crocarneiro.puzzle1.Puzzle1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Puzzle2 {
    private static Map<String, Hand> letterHandMap = new HashMap<>();

    static {
        letterHandMap.put("A", Hand.ROCK);
        letterHandMap.put("X", Hand.ROCK);
        letterHandMap.put("B", Hand.PAPER);
        letterHandMap.put("Y", Hand.PAPER);
        letterHandMap.put("C", Hand.SCISSOR);
        letterHandMap.put("Z", Hand.SCISSOR);
    }

    public static void main(String args[]) {
        try (var inputStream  = Puzzle2.class.getResourceAsStream("input.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            var overallScore = 0;
            while((line = bufferedReader.readLine()) != null) {
                var handsEncrypted = line.split(" ");
                var enemyHand = letterHandMap.get(handsEncrypted[0]);
                var myHand = letterHandMap.get(handsEncrypted[1]);

                var roundScore = 0;
                switch (myHand) {
                    case ROCK -> {
                        switch(enemyHand) {
                            case PAPER -> roundScore += 0; // I lost
                            case SCISSOR -> roundScore += 6; // I won
                            case ROCK -> roundScore += 3; // Draw
                        }
                    }
                    case PAPER -> {
                        switch(enemyHand) {
                            case PAPER -> roundScore += 3; // I lost
                            case SCISSOR -> roundScore += 0; // I won
                            case ROCK -> roundScore += 6; // Draw
                        }
                    }
                    case SCISSOR -> {
                        switch(enemyHand) {
                            case PAPER -> roundScore += 6; // I lost
                            case SCISSOR -> roundScore += 3; // I won
                            case ROCK -> roundScore += 0; // Draw
                        }
                    }
                }

                roundScore += myHand.score;
                overallScore += roundScore;
                System.out.println(enemyHand.name() + " " + myHand.name() + " = " + roundScore);
            }

            System.out.println("Overall score = " + overallScore);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
