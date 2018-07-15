package ru.job4j.logic;

/**
 * Метод поиска пересечений отрезков AB и CD на прямой, при условии (A больше B) (C больше D)
 *
 * @author Komar Valerii
 * @version 1.0
 */
public class Intersection {

    /**
     *
     * @param a начало отрезка АВ
     * @param b конец отрезка АВ
     * @param c начало отрезка CD
     * @param d конец отрезка CD
     * @return факт пересечения отрезков AB и CD
     */
    public boolean crossing(double a, double b, double c, double d) {
        boolean result = false;
        if ((a <= c) && (c <= b)) {
            result = true;
        } else
            if ((a <= d) && (c <= a)) {
                result = true;
            }
        return result;
    }
}
