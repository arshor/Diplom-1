package praktikum;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BunTests {

    private Bun bun;

    @Before
    public void setUp() {

        bun = new Bun("fun_bun", 149.99f);
    }

    @Test
    public void getName() {
        String expected = "fun_bun";
        String actual = bun.getName();

        assertEquals("Не верное название булочки", expected, actual);
    }

    @Test
    public void getPrice() {
        float expected = 149.99f;
        float actual = bun.getPrice();

        assertEquals("Не верное значение стоимости булочки", expected, actual, 0);
    }
}
