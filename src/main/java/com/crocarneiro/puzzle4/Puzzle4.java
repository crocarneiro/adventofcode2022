package com.crocarneiro.puzzle4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Puzzle4 {
    public static void main(String[] args) {
        try(var inputStream = Puzzle4.class.getResourceAsStream("testInput.txt")) {
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            int count = 0;
            while((line = bufferedReader.readLine()) != null) {
                var elfs = line.split(",");
                var elf1 = elfs[0];
                var elf2 = elfs[1];

                var range1 = getRangeFromElf(elf1);
                var range2 = getRangeFromElf(elf2);

                if(range1.fullyContains(range2) || range2.fullyContains(range1))
                    count++;

                System.out.println("Elf 1: " + elf1 + "\tElf 2: " + elf2);
            }

            System.out.println("Count = " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Range getRangeFromElf(String elf) {
        var values = elf.split("-");
        return new Range(Long.parseLong(values[0]), Long.parseLong(values[1]));
    }
}
