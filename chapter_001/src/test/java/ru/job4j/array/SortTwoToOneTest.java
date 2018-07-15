package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SortTwoToOneTest {
    @Test
    public void whenTwoSameArrays() {
        SortTwoToOne sorttwotoone = new SortTwoToOne();
        int[] result = sorttwotoone.sort(new int[]{1, 2, 3, 4, 5, 9, 19}, new int[]{1, 2, 3, 4, 5, 9, 19});
        assertThat(result, is(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 9, 9, 19, 19}));
    }
    @Test
    public void whenTwoDifferentArrays() {
        SortTwoToOne sorttwotoone = new SortTwoToOne();
        int[] result = sorttwotoone.sort(new int[]{-1, 0, 7, 8, 11, 23}, new int[]{1, 2, 3, 4, 5, 9, 19});
        assertThat(result, is(new int[]{-1, 0, 1, 2, 3, 4, 5, 7, 8, 9, 11, 19, 23}));
    }
    @Test
    public void whenOneSubTwo() {
        SortTwoToOne sorttwotoone = new SortTwoToOne();
        int[] result = sorttwotoone.sort(new int[]{1, 3, 4}, new int[]{1, 3, 4, 4, 5, 9, 19});
        assertThat(result, is(new int[]{1, 1, 3, 3, 4, 4, 4, 5, 9, 19}));
    }
    @Test
    public void whenOneSubTwoChangePlace() {
        SortTwoToOne sorttwotoone = new SortTwoToOne();
        int[] result = sorttwotoone.sort(new int[]{1, 3, 4, 4, 5, 9, 19}, new int[]{1, 3, 4});
        assertThat(result, is(new int[]{1, 1, 3, 3, 4, 4, 4, 5, 9, 19}));
    }
    @Test
    public void whenTwoByOneElement() {
        SortTwoToOne sorttwotoone = new SortTwoToOne();
        int[] result = sorttwotoone.sort(new int[]{1}, new int[]{2});
        assertThat(result, is(new int[]{1, 2}));
    }
}
