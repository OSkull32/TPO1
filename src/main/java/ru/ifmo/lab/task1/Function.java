package ru.ifmo.lab.task1;

public class Function {
    public static double sin(double x, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть положительным");
        }

        double PI2 = Math.PI * 2;
        x = x % PI2; // Нам нужен только этот диапазон [-2π, 2π]
        if (x < 0) {
            x += PI2; // Если x отрицательный, то добавляем 2π, чтобы попасть в диапазон [0, 2π)
        }

        double result = 0;
        double x2 = x * x;
        double term = x;

        for (int i = 1; i <= n; i += 2) {
            result += term;
            term *= -x2/ ((i + 1) * (i + 2)); // Вычисляем следующий член ряда
        }

        return result;
    }
}
