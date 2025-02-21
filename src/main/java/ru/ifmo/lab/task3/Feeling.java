package ru.ifmo.lab.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Feeling {
    CONFIDENT("уверенный"),
    LOST("потерянный"),
    ANXIOUS("тревожный"),
    CURIOUS("любопытный");

    private final String displayName;
}