package ru.job4j.array;

/**
 * Пузырьковая сортировка
 */
public class BubbleSort {
    /**
     *
     * @param  array входящий массив типа int для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
