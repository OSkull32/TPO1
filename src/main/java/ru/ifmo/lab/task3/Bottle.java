package ru.ifmo.lab.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class Bottle {
    private Fish fish;

    public void shake() {
        System.out.println("В бутылке плещется маленькая желтая рыбка.");
    }
}
