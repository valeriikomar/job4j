package ru.job4j.loop;

/**
 * Вычисление факториала
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Factorial {
    /**
     *
     * @param n число факториала
     * @return факториал числа
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
