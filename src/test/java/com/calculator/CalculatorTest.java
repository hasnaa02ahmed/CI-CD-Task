package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Calculator Unit Tests")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ─── Addition ───────────────────────────────────────────────────────────

    @Test
    @DisplayName("Add two positive numbers")
    void testAddPositiveNumbers() {
        assertEquals(10.0, calculator.add(4.0, 6.0), "4 + 6 should equal 10");
    }

    @Test
    @DisplayName("Add a positive and a negative number")
    void testAddPositiveAndNegative() {
        assertEquals(1.0, calculator.add(5.0, -4.0), "5 + (-4) should equal 1");
    }

    @Test
    @DisplayName("Add two negative numbers")
    void testAddTwoNegatives() {
        assertEquals(-9.0, calculator.add(-4.0, -5.0), "-4 + (-5) should equal -9");
    }

    // ─── Subtraction ────────────────────────────────────────────────────────

    @Test
    @DisplayName("Subtract smaller from larger")
    void testSubtract() {
        assertEquals(5.0, calculator.subtract(10.0, 5.0), "10 - 5 should equal 5");
    }

    @Test
    @DisplayName("Subtract resulting in negative")
    void testSubtractNegativeResult() {
        assertEquals(-3.0, calculator.subtract(2.0, 5.0), "2 - 5 should equal -3");
    }

    // ─── Multiplication ─────────────────────────────────────────────────────

    @Test
    @DisplayName("Multiply two positive numbers")
    void testMultiply() {
        assertEquals(20.0, calculator.multiply(4.0, 5.0), "4 * 5 should equal 20");
    }

    @Test
    @DisplayName("Multiply by zero")
    void testMultiplyByZero() {
        assertEquals(0.0, calculator.multiply(99.0, 0.0), "Any number * 0 should equal 0");
    }

    @Test
    @DisplayName("Multiply two negatives gives positive")
    void testMultiplyTwoNegatives() {
        assertEquals(6.0, calculator.multiply(-2.0, -3.0), "-2 * -3 should equal 6");
    }

    // ─── Division ───────────────────────────────────────────────────────────

    @Test
    @DisplayName("Divide two numbers evenly")
    void testDivide() {
        assertEquals(4.0, calculator.divide(20.0, 5.0), "20 / 5 should equal 4");
    }

    @Test
    @DisplayName("Divide by zero throws ArithmeticException")
    void testDivideByZeroThrows() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> calculator.divide(10.0, 0.0));
        assertEquals("Division by zero is not allowed.", ex.getMessage());
    }

    // ─── Absolute Value ─────────────────────────────────────────────────────

    @Test
    @DisplayName("Absolute value of a negative number")
    void testAbsNegative() {
        assertEquals(5.0, calculator.abs(-5.0), "abs(-5) should equal 5");
    }

    @Test
    @DisplayName("Absolute value of a positive number")
    void testAbsPositive() {
        assertEquals(7.0, calculator.abs(7.0), "abs(7) should equal 7");
    }

    // ─── Square Root ────────────────────────────────────────────────────────

    @Test
    @DisplayName("Square root of a perfect square")
    void testSqrt() {
        assertEquals(4.0, calculator.sqrt(16.0), "sqrt(16) should equal 4");
    }

    @Test
    @DisplayName("Square root of negative throws ArithmeticException")
    void testSqrtNegativeThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(-1.0));
    }
}
