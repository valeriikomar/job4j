package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            String temp = "";
            for (int j = i + 1; j < array.length - 1 - count; j++) {
                if (array[i] == array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                if (temp != "") {
                    count++;
                }
            }
        } return Arrays.copyOf(array, array.length - 1 - count);
    }
}
