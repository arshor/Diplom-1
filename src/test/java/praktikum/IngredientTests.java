package praktikum;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    private Ingredient ingredient;
    private final String expectedIngredientName = "1000islands";
    private final float expectedIngredientPrice = 4.99f;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, expectedIngredientName, expectedIngredientPrice);
    }

    @Test
    public void getNameTest() {

        String actualIngredientName = ingredient.getName();

        assertEquals("Не верное название ингредиента", expectedIngredientName, actualIngredientName);
    }

    @Test
    public void getPriceTest() {

        float actualIngredientPrice = ingredient.getPrice();

        assertEquals("Не верное значение стоимости ингредиента", expectedIngredientPrice, actualIngredientPrice, 0);
    }
}
