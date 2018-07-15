package ru.job4j.array;

/**
 * Поиск индекса входящего элемента
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class FindLoop {
    /**
     * Метод поиска
     * @param data входящий массив для поиска
     * @param el искомый элемент
     * @return индекс элемента
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}