package com.crocarneiro.puzzle2;

public enum Hand {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    int score;

    Hand(int _score) {
        this.score = _score;
    }
}
