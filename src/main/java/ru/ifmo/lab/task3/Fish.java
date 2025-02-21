package ru.ifmo.lab.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Fish {
    private Color color;
    private Size size;
    private Item item;

    public void shimmer(Color color) {
        this.color = color;
        System.out.println("Рыбка переливается красивыми оттенками " + color);
    }

    public void swim(Item where) {
        this.item = where;
        System.out.println("Рыбка плавает в бутылке.");
    }
}