package ru.job4j.array;

/**
 * Таблица умножения
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Matrix {
    /**
     *
     * @param size размер таблицы (горизонталь и вертикаль)
     * @return заполненный массив таблицей умножения
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
