package ru.ifmo.lab.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Name {
    FORD("Форд"),
    ARTHUR("Артур");

    private final String displayName;
}
