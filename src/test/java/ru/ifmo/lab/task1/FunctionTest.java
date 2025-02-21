package ru.ifmo.lab.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {
    @ParameterizedTest(name = "sin")
    @DisplayName("Check Pi dots")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, -0.5 * Math.PI, 0, 0.5 * Math.PI, Math.PI, 2 * Math.PI})
    void checkPiDots(double value) {
        assertAll(
                () -> assertEquals(Math.sin(value), Function.sin(value, 50), 0.000000000000001)
        );
    }

    @ParameterizedTest(name = "sin")
    @DisplayName("Check between dots -1; 1")
    @CsvFileSource(resources = "/sin_value.csv", numLinesToSkip = 1, delimiter = ',')
    void checkBetweenDots(double x, double y) {
        assertAll(
                () -> assertEquals(y, Function.sin(x, 50), 0.00000000000001)
        );
    }
}
