package ru.job4j.array;

/**
 * "Переворачивание" массива
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Turn {
    /**
     * Реализующий метод
     * @param array входящий массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
