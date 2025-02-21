package ru.ifmo.lab.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bottle {
    private Fish fish;

    public void shake(Fish fish) {
        this.fish = fish;
        System.out.println("В бутылке плещется маленькая желтая рыбка.");
    }
}
