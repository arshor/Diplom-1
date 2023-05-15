package praktikum;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BunTests {

    private Bun bun;
    private final String expectedBunName = "fun_bun";
    private final float expectedBunPrice = 149.99f;

    @Before
    public void setUp() {

        bun = new Bun(expectedBunName, expectedBunPrice);
    }

    @Test
    public void getNameTestShowsOk() {

        String actualBunName = bun.getName();

        assertEquals("Не верное название булочки", expectedBunName, actualBunName);
    }

    @Test
    public void getPriceTestShowsOk() {

        float actualBunPrice = bun.getPrice();

        assertEquals("Не верное значение стоимости булочки", expectedBunPrice, actualBunPrice, 0);
    }
}
