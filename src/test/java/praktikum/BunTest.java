package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    private final String nameBun = "red bun";
    private final float priceBun = 300F;

    @Before
    public void createBun() {
        bun = new Bun(nameBun, priceBun);
    }

    @Test
    public void getBunNameTest() {
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        assertEquals(priceBun, bun.getPrice(), 0F);
    }

}
