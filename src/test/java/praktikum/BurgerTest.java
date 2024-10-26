package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient sauce;
    @Mock
    Bun bun;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getReceiptTest() {
        String expectedPrintReceipt = "(==== red bun ====)" + "\r\n"
                + "= sauce chili sauce =" + "\r\n"
                + "(==== red bun ====)" + "\r\n"
                + "\r\n"
                + "Price: 900,000000" + "\r\n";

        burger.addIngredient(sauce);
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(sauce.getName()).thenReturn("chili sauce");
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(sauce.getPrice()).thenReturn(300F);

        assertEquals(expectedPrintReceipt, burger.getReceipt());
    }

}


