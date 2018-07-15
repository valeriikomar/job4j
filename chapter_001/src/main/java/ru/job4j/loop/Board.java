package ru.job4j.loop;

/**
 * Построение шахматной доски
 * @author Komar Valerii (val1988x@gmail.com)
 */
public class Board {
    /**
     *
     * @param width ширина
     * @param height высота
     * @return вывод в консоль
     */
    public  String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
