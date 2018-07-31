package ru.job4j.psevdo;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Valerii Komar (mailto:val1988x@gmail.com)
 * @version 29.07.18
 * @since 0.1
 */
public class PaintTest {
   @Test
   public void whenDrawSquare() {
       PrintStream stdout = System.out;
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));
       new Paint().draw(new Square());
       assertThat(
               new String(out.toByteArray()),
               is(
                       new StringBuilder()
                               .append("++++\n")
                               .append("+  +\n")
                               .append("+  +\n")
                               .append("++++\n")
                               .append(System.lineSeparator())
                               .toString()

               )
       );
       System.setOut(stdout);
   }
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  +\n")
                                .append(" +++\n")
                                .append("+++++\n")
                                .append(System.lineSeparator())
                                .toString()

                )
        );
        System.setOut(stdout);
    }
}
