package ru.job4j.max;

/**
 * Нахождение максимального числа среди трёх
 * @author Komar Valerii (val1988x@gmail.com
 * @since 0.1
 */
public class Max {
    /**
     *
     * @param first первое число
     * @param second второе число
     * @return большее
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     *
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @return большее
     */
    public int max(int first, int second, int third) {
        return this.max(max(first, second), third);
    }
}
