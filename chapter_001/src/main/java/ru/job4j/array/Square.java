package ru.job4j.array;

/**
 * Заполнение массива степенями его индексов
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Square {
    /**
     * Метод реализации
     * @param bound входящяя длина массива
     * @return массив с возведёнными степенями от индексов
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
