package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(new String[] {
               "При1вет", "При1вет", "Hello", "При1вет", "При1вет"});
        assertThat(result, is(new String[]{"При1вет", "Hello"}));
    }
}
