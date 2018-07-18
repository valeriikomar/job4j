package ru.job4j.array;

/**
 * Реализация отсортированного массива из 2 входящих отсортированных, путём добавления элементов без сортировки
 * @author Komar Valerii (val1988x@gmail.com)
 * @version 13.07.2018
 * @since 0.1
 */
public class SortTwoToOne {
    /**
     *
     * @param a первый отсортированный массив
     * @param b второй отсортированный массив
     * @return отсортированный массив с элементами массивов а и b
     */
    public int[] sort(int[] a, int[] b) {
        int x = 0;
        int y = 0;
        boolean finishA = false;
        boolean finishB = false;
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length + b.length;) {
            while (((finishB) & (!finishA)) || ((!finishA) && (a[x] <= b[y]))) {
                result[i] = a[x];
                i++;
                x++;
                if (x == a.length) {
                    finishA = true;
                }
            }
            while (((finishA) & (!finishB)) || ((!finishB) && (b[y] <= a[x]))) {
                result[i] = b[y];
                i++;
                y++;
                if (y == b.length) {
                    finishB = true;
                }
            }

/*            if ((x < a.length) && (y < b.length)) {
                if (a[x] <= b[y]) {
                    result[i] = a[x];
                    x++;
                } else
                    if (b[y] < a[x]) {
                    result[i] = b[y];
                    y++;
                    }
            } else
                if (x < a.length) {
                    result[i] = a[x];
                    x++;
                } else
                    if (y < b.length) {
                        result[i] = b[y];
                        y++;
                    }
*/
        }

        return result;
    }
}
