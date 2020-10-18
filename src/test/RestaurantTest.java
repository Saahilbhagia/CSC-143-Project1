package test;

import lib.Pair;
import org.junit.Before;
import org.junit.Test;
import world.*;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.*;

public class RestaurantTest {
    private Restaurant burgerStand;

    @Before
    public void setUp() {
        burgerStand = new Restaurant("Inner Campus Drive", "Frank's");
    }

    @Test
    public void RestaurantConstructorTest() {
        Building burgerKing = new Restaurant("Inner Campus Drive", "Frank's");
        assertTrue(true);
    }

    @Test
    public void RestaurantSupplyInterfaceTest() {
        if (!(burgerStand instanceof Store)) {
            fail();
        }

        Store burgerStand = (Store) this.burgerStand;
        burgerStand.supply(Arrays.asList(new Pair<>("Meat", 1),
                new Pair<>("Bread", 1)));
        assertTrue(true);
    }

    @Test
    public void RestaurantGetProductsInterfaceTest() {
        if (!(burgerStand instanceof Store)) {
            fail();
        }

        Store burgerStand = (Store) this.burgerStand;
        assertEquals(0, burgerStand.getProducts().size());
    }

    @Test
    public void RestaurantLearnRecipeInterfaceTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

        burgerStand.learnRecipe("Burger", burgerRecipe);
        assertTrue(true);
    }

    @Test
    public void RestaurantGetProductsSimpleTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.supply(burgerRecipe);

        Collection<Pair<String, Integer>> expectedProducts = Arrays.asList(
                new Pair<>("Burger", 1)
        );
        assertEquals(expectedProducts, burgerStand.getProducts());
    }

    @Test
    public void RestaurantGetProductsMultipleTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.supply(burgerRecipe);
        burgerStand.supply(burgerRecipe);

        Collection<Pair<String, Integer>> expectedProducts = Arrays.asList(
                new Pair<>("Burger", 2)
        );

        burgerStand.supply(Arrays.asList(
                new Pair<>("Bread", 6),
                new Pair<>("Meat", 2)));

        expectedProducts = Arrays.asList(new Pair<>("Burger", 4));
        assertEquals(expectedProducts, burgerStand.getProducts());
    }

    @Test
    public void RestaurantGetProductsMixedTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1),
                new Pair<>("Lettuce", 1),
                new Pair<>("Tomato", 1));
        Collection<Pair<String, Integer>> saladRecipe = Arrays.asList(
                new Pair<>("Lettuce", 2),
                new Pair<>("Tomato", 1)
        );

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.learnRecipe("Salad", saladRecipe);

        burgerStand.supply(Arrays.asList(
                new Pair<>("Bread", 4),
                new Pair<>("Meat", 4),
                new Pair<>("Lettuce", 4),
                new Pair<>("Tomato", 4)));

        Collection<Pair<String, Integer>> expectedProducts = Arrays.asList(
                new Pair<>("Burger", 2),
                new Pair<>("Salad", 2)
        );
        assertEquals(expectedProducts, burgerStand.getProducts());
    }

    @Test
    public void RestaurantPurchaseSimpleTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.supply(burgerRecipe);

        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList(
                new Pair<>("Burger", 1)
        );
        assertEquals(expectedPurchase, burgerStand.purchase(expectedPurchase));
    }

    @Test
    public void RestaurantPurchaseOutOfStockTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.supply(Arrays.asList(new Pair<>("Meat", 1)));

        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList();
        assertEquals(expectedPurchase, burgerStand.purchase(new Pair<>("Burger", 1)));
    }

    @Test
    public void RestaurantPurchaseNoRecipeTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

 //Never learned the burger recipe, can't deliver any burgers



        // burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.supply(burgerRecipe);

        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList();
        assertEquals(expectedPurchase, burgerStand.purchase(new Pair<>("Burger", 1)));
    }

    @Test
    public void RestaurantPurchaseMultipleTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1));

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.supply(burgerRecipe);
        burgerStand.supply(burgerRecipe);
        burgerStand.supply(Arrays.asList(new Pair<>("Bread", 1)));

        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList(
                new Pair<>("Burger", 2)
        );
        assertEquals(expectedPurchase, burgerStand.purchase(expectedPurchase));

        Collection<Pair<String, Integer>> noBurgers = Arrays.asList();
        assertEquals(noBurgers, burgerStand.purchase(expectedPurchase));
    }

    @Test
    public void RestaurantPurchaseMixedTest() {
        Collection<Pair<String, Integer>> burgerRecipe = Arrays.asList(
                new Pair<>("Bread", 2),
                new Pair<>("Meat", 1),
                new Pair<>("Lettuce", 1),
                new Pair<>("Tomato", 1));
        Collection<Pair<String, Integer>> saladRecipe = Arrays.asList(
                new Pair<>("Lettuce", 2),
                new Pair<>("Tomato", 1)
        );

        burgerStand.learnRecipe("Burger", burgerRecipe);
        burgerStand.learnRecipe("Salad", saladRecipe);

        burgerStand.supply(Arrays.asList(
                new Pair<>("Bread", 6),
                new Pair<>("Meat", 6),
                new Pair<>("Lettuce", 6),
                new Pair<>("Tomato", 6)));





 //Buy out all three burgers



        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList(
                new Pair<>("Burger", 3)
        );
        assertEquals(expectedPurchase, burgerStand.purchase(new Pair<>("Burger", 3)));





 //There's only 3 lettuce left, enough for 1 salad



        Collection<Pair<String, Integer>> expectedProducts = Arrays.asList(
                new Pair<>("Burger", 0),
                new Pair<>("Salad", 1)
        );
        assertEquals(expectedProducts, burgerStand.getProducts());





 ///Attempt to buy a burger and two salads, receive only one salad



        expectedPurchase = Arrays.asList(
                new Pair<>("Salad", 1)
        );
        assertEquals(expectedPurchase, burgerStand.purchase(Arrays.asList(
                new Pair<>("Burger", 1), new Pair<>("Salad", 2))));
    }
}


