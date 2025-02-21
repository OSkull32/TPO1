package ru.ifmo.lab.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human {
    private Name name;
    @Getter
    private Feeling feeling;

    public void hold(Item item) {
        System.out.println(name + " держит " + item.name());
    }

    public void lookAt(Name name2) {
        System.out.println(name + " смотрит на " + name2.name());
    }

    public void blink() {
        System.out.println(name + " моргает глазами.");
    }

    public void feel(Feeling newFeeling) {
        this.feeling = newFeeling;
        System.out.println(name + " чувствует себя " + newFeeling.toString().toLowerCase());
    }
}