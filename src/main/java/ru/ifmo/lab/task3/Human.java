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
    private Item item;
    private Action action;

    public void hold(Item item) {
        this.item = item;
        System.out.println(name + " держит " + item.name());
    }

    public void lookAt(Name name2) {
        this.action = Action.LOOK;
        System.out.println(name + " смотрит на " + name2.name());
    }

    public void blink() {
        this.action = Action.BLINK;
        System.out.println(name + " моргает глазами.");
    }

    public void feel(Feeling newFeeling) {
        this.feeling = newFeeling;
        System.out.println(name + " чувствует себя " + newFeeling.toString().toLowerCase());
    }
}