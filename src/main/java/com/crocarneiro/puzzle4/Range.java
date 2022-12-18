package com.crocarneiro.puzzle4;

public record Range(Long min, Long max) {
    public boolean fullyContains(Range range) {
        return min >= range.min() && max <= range.max();
    }

    public boolean overlaps(Range range) {
        return (min >= range.min() && min <= range.max()) ||
                (max >= range.min() && max <= range.max());
    }
}
