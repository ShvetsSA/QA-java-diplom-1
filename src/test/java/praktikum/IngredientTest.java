package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters
    public static Object[][] Ingredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100F},
                {IngredientType.FILLING, "cutlet", 100F}
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceIngredientTest() {
        assertEquals(price, ingredient.getPrice(), 0F);
    }

    @Test
    public void getNameIngredientTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeIngredientTest() {
        assertEquals(type, ingredient.getType());
    }
}


