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

    public void shimmer() {
        System.out.println("Рыбка переливается красивыми оттенками " + color);
    }

    public void swim() {
        System.out.println("Рыбка плавает в бутылке.");
    }
}