import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredientNew;


    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTestShowsOk() {
        burger.setBuns(bun);

        assertEquals("Не верно задается булочка для бургера", bun, burger.bun);
    }

    @Test
    public void addIngredientTestShowsOk() {
        burger.addIngredient(ingredient);

        assertEquals("Ингредиент не добавляется в список ингредиентов", List.of(ingredient), burger.ingredients);
    }

    @Test
    public void removeIngredientTestShowsOk() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals("Ингредиент не удаляется из списка ингредиентов", List.of(), burger.ingredients);
    }

    @Test
    public void moveIngredientTestShowsOk() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientNew);
        burger.moveIngredient(0, 1);

        assertEquals("Список ингредиентов не соответствует требуемому", List.of(ingredientNew, ingredient), burger.ingredients);
    }

    @Test
    public void getPriceTestShowsOk() {
        Mockito.when(bun.getPrice()).thenReturn(5.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(15.0f);
        Mockito.when(ingredientNew.getPrice()).thenReturn(19.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientNew);

        assertEquals("Стоимость бургера посчитана не верно", 44.0f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTestShowsOk() {
        Mockito.when(bun.getPrice()).thenReturn(5.0f);
        Mockito.when(bun.getName()).thenReturn("fun bun");
        Mockito.when(ingredient.getPrice()).thenReturn(15.0f);
        Mockito.when(ingredient.getName()).thenReturn("tomato");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientNew.getPrice()).thenReturn(19.0f);
        Mockito.when(ingredientNew.getName()).thenReturn("1000islands");
        Mockito.when(ingredientNew.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientNew);
        List<Ingredient> ingredients = List.of(ingredient, ingredientNew);

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            expected.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Стоимость бургера посчитана не верно", expected.toString(), burger.getReceipt());
    }

}
