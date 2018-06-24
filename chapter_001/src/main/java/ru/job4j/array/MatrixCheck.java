package ru.job4j.array;

public class MatrixCheck {
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
