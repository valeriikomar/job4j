package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Valerii Komar (val1988x@gmail.com)
 * @version $ld$
 * @since 0.1
 */
public class CalculateTest{
/**
 * Test echo.
 */ @Test
public void whenTakeNameThenTreeEchoPlusName(){
	String input = "Valerii Komar";
	String expect = "Echo, echo, echo : Valerii Komar";
	Calculate calc = new Calculate();
	String result = calc.echo(input);
	assertThat(result, is(expect));
}
}