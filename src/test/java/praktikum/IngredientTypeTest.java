package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}
