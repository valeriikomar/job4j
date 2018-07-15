package ru.job4j.converter;

/**
 * Корвертор валюты.
 * @author Komar Valerii (val1988x@gmail.com)
 * @since 0.1
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value Рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value Рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем доллары в рубли
     * @param value Доллары
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }

    /**
     * Конвертируем евро в рубли
     * @param value Евро
     * @return Рубли
     */
    public int euroToRuble(int value) {
        return value * 70;
    }
}
