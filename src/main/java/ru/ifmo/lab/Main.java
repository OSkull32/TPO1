package ru.ifmo.lab;

import ru.ifmo.lab.task3.Bottle;
import ru.ifmo.lab.task3.Color;
import ru.ifmo.lab.task3.Fish;
import ru.ifmo.lab.task3.Size;

public class Main {
    public static void main(String[] args) {
        Bottle bottle = new Bottle(new Fish(Color.BLACK, Size.LARGE));
    }
}