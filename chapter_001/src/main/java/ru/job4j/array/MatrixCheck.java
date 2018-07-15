package ru.job4j.array;

/**
 * Проверка заполнения true или false по диагоналям
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class MatrixCheck {
    /**
     *
     * @param data входящий двумерный массив
     * @return результат условия
     */
    public boolean mono(boolean[][] data) {
        boolean result = true, temp = data[0][0];
        for (int i = 0; i < data.length - 1; i++) {
            if ((data[i][i] != temp) || (data[data.length - 1 - i][i] != temp)) {
               result = false;
               break;
            }
        }
        return result;
    }
}
