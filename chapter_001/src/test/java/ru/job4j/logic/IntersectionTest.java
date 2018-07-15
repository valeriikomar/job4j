package ru.job4j.logic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class IntersectionTest {
    @Test
    public void whenABbeforeCD() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(0, 5, 6, 8);
        assertThat(result, is(false));
    }
    @Test
    public void whenABafterCD() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(9, 11, 6, 8);
        assertThat(result, is(false));
    }
    @Test
    public void whenABinsideCD() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(5, 6, 4, 8);
        assertThat(result, is(true));
    }
    @Test
    public void whenCDinsideAB() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(0, 6, 4, 5);
        assertThat(result, is(true));

    }
    @Test
    public void whenABsameCD() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(0, 1, 0, 1);
        assertThat(result, is(true));
    }
    @Test
    public void whenABandCDIntersectionInPointB() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(0, 1, 1, 2);
        assertThat(result, is(true));
    }
    @Test
    public void whenABandCDIntersectionInPointA() {
        Intersection intersection = new Intersection();
        boolean result = intersection.crossing(5, 6, 1, 5);
        assertThat(result, is(true));
    }
}
