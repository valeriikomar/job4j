package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(new String[] {
                "Привет", "Мир", "Привет", "Супер", "Мир"});
        assertThat(result, is(new String[]{"Привет", "Мир", "Супер"}));
    }
}
