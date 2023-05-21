import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameParamTest {

    private Bun bun;
    private final String name;

    public BunNameParamTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {""},
                {null},
                {"           "},
                {RandomStringUtils.randomAlphabetic(1000000000)},
                {RandomStringUtils.randomNumeric(100)},
                {RandomStringUtils.randomAscii(100)},
                {"bun\tbun\n\'\"\\"},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, 1.0f);
    }

    @Test
    public void paramTest() {
        String actualBunName = bun.getName();

        assertEquals("Не верное значение названия булочки", name, actualBunName);
    }
}
