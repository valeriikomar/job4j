package ru.job4j.array;

import java.util.Arrays;

/**
 * Поиск дубликатов и сортировка.
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class ArrayDuplicate {
    /**
     *
     * @param array входящий массив для поиска
     * @return отсортированный массив без дубликатов
     */
    public String[] remove(String[] array) {
        int count = 0;
        String temp = "";
        for (int i = 0; i < array.length - 1 - count; i++) {
            for (int j = i + 1; j < array.length - count; j++) {
                if (array[i] == array[j]) {
                    for (int k = j; k < array.length - 1 - count; k++) {
                        temp = array[k];
                        array[k] = array[k + 1];
                        array[k + 1] = temp;
                    }
                    count++;
                    j--;
                }
            }
        } return Arrays.copyOf(array, array.length - count);
    }
}
