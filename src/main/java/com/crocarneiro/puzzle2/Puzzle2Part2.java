package com.crocarneiro.puzzle2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

enum RoundResult {
    WIN(6),
    LOSS(0),
    DRAW(3);

    int score;

    RoundResult(int _score) {
        score = _score;
    }
}

public class Puzzle2Part2 {
    private static Map<String, Hand> letterHandMap = new HashMap<>();
    public static Map<String, RoundResult> letterResultMap = new HashMap<>();



    static {
        letterHandMap.put("A", Hand.ROCK);
        letterHandMap.put("B", Hand.PAPER);
        letterHandMap.put("C", Hand.SCISSOR);

        letterResultMap.put("X", RoundResult.LOSS);
        letterResultMap.put("Y", RoundResult.DRAW);
        letterResultMap.put("Z", RoundResult.WIN);




    }

    public static void main(String args[]) {
        try (var inputStream  = Puzzle2.class.getResourceAsStream("input.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            var overallScore = 0;
            while((line = bufferedReader.readLine()) != null) {
                var handsEncrypted = line.split(" ");
                var enemyHand = letterHandMap.get(handsEncrypted[0]);

                var desiredOutcome = letterResultMap.get(handsEncrypted[1]);

                var myHand = getHandByDesiredResult(desiredOutcome, enemyHand);

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

    private static Hand getHandByDesiredResult(RoundResult desiredReult, Hand enemyHand) {
        return switch (enemyHand) {
            case ROCK -> switch (desiredReult) {
                case WIN -> Hand.PAPER;
                case LOSS -> Hand.SCISSOR;
                case DRAW -> Hand.ROCK;
            };
            case PAPER -> switch (desiredReult) {
                case WIN -> Hand.SCISSOR;
                case LOSS -> Hand.ROCK;
                case DRAW -> Hand.PAPER;
            };
            case SCISSOR -> switch (desiredReult) {
                case WIN -> Hand.ROCK;
                case LOSS -> Hand.PAPER;
                case DRAW -> Hand.SCISSOR;
            };
        };
    }
}
