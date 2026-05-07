package com.calculator;

/**
 * A simple Calculator utility class.
 * Supports basic arithmetic operations.
 */
public class Calculator {

    // Adds two numbers.
    public double add(double a, double b) {
        return a + b;
    }


    // Subtracts b from a.     
    public double subtract(double a, double b) {
        return a - b;
    }

    
    // Multiplies two numbers.     
    public double multiply(double a, double b) {
        return a * b;
    }


    /**
     * Divides a by b.
     * @throws ArithmeticException if b is zero.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }


     // Returns the absolute value of a number.
    public double abs(double a) {
        return Math.abs(a);
    }


    /**
     * Returns the square root of a number.
     * @throws ArithmeticException if a is negative.
     */
    public double sqrt(double a) {
        if (a < 0) {
            throw new ArithmeticException("Cannot compute square root of a negative number.");
        }
        return Math.sqrt(a);
    }
}
