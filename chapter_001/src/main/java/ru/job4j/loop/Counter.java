package ru.job4j.loop;

/**
 * Сумма чётный чисел в заданном диапазоне
 * @author Komar Valerii (val1988x@gmail.com)
 * @since 0.1
 */
public class Counter {
    /**
     *
     * @param start начало диапазона
     * @param finish конец диапазона
     * @return сумма
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if ((i % 2) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
