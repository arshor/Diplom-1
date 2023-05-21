import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static java.lang.Float.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceParamTest {

    private Bun bun;
    private final float price;

    public BunPriceParamTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {0},
                {10},
                {-10},
                {MAX_VALUE},
                {MIN_VALUE},
                {NaN},
                {POSITIVE_INFINITY},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun("fun bun", price);
    }

    @Test
    public void paramTest() {
        float actualBunPrice = bun.getPrice();

        assertEquals("Не верное значение стоимости булочки", price, actualBunPrice, 0);
    }
}
