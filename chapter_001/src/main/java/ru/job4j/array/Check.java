package ru.job4j.array;

/**
 * Проверка на заполнение массива true или false
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Check {
    /**
     *
     * @param data входящий массив
     * @return результат true или false условия
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
