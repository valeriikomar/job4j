package ru.job4j.calculator;

/**
 * Calculator
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Calculator {
    private double result;

    /**
     * Сложение
     * @param first первое число
     * @param second второе число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Геттер
     * @return результат
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Вычитание
     * @param first первое число
     * @param second второе число
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление
     * @param first первое число
     * @param second второе число
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умножение
     * @param first первый число
     * @param second второе число
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
