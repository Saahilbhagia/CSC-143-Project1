package test;

import lib.Pair;
import org.junit.Before;
import org.junit.Test;
import world.Building;
import world.Store;
import world.Supermarket;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static junit.framework.TestCase.*;

public class SupermarketTest {
    private Supermarket safeway;

    @Before
    public void setUp() {
        safeway = new Supermarket("Inner Campus Drive", "Safeway");
    }

    @Test
    public void SupermarketConstructorTest() {
        Building safeway = new Supermarket("Inner Campus Drive", "Safeway");
        assertTrue(true);
    }

    @Test
    public void SupermarketSupplyInterfaceTest() {
        if (!(safeway instanceof Store)) {
            fail();
        }

        Store market = (Store) safeway;
        market.supply(Arrays.asList(new Pair<>("Apple", 1),
                new Pair<>("Orange", 1)));
        assertTrue(true);
    }

    @Test
    public void SupermarketGetProductsInterfaceTest() {
        if (!(safeway instanceof Store)) {
            fail();
        }

        Store market = (Store) safeway;
        assertEquals(0, market.getProducts().size());
    }

    @Test
    public void SupermarketProductListingTest() {
        safeway.supply(Arrays.asList(
                new Pair<>("Apple", 2),
                new Pair<>("Orange", 1)));

        Collection<Pair<String, Integer>> products = safeway.getProducts();

        /* Output order isn't enforced, so we'll package the output into a set. */
        HashSet<Pair<String, Integer>> productSet = new HashSet<>(products);
        assertTrue(productSet.contains(new Pair<>("Orange", 1)));
        assertTrue(productSet.contains(new Pair<>("Apple", 2)));
        assertEquals(2, productSet.size());
    }

    @Test
    public void SupermarketSupplyPurchaseTest() {
        safeway.supply(Arrays.asList(
                new Pair<>("Apple", 2),
                new Pair<>("Orange", 1)));

        HashSet<Pair<String, Integer>> productListing = new HashSet<>(safeway.getProducts());

        /* Empty purchase order, product listing should remain unchanged */
        Collection<Pair<String, Integer>> purchase = safeway.purchase(Arrays.asList());

        HashSet<Pair<String, Integer>> newProductListing = new HashSet<>(safeway.getProducts());
        assertEquals(productListing, newProductListing);

        /* How do you like them apples? (Buy some apples) */
        Pair<String, Integer> twoApples = new Pair<>("Apple", 2);

        purchase = safeway.purchase(twoApples);
        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList(twoApples);
        assertEquals(expectedPurchase, purchase);

        /* One orange and zero apples should remain. */
        HashSet<Pair<String, Integer>> productSet = new HashSet<>(safeway.getProducts());
        assertTrue(productSet.contains(new Pair<>("Orange", 1)));
        assertTrue(productSet.contains(new Pair<>("Apple", 0)));
    }

    @Test
    public void SupermarketSupplyPurchaseExtrasTest() {
        safeway.supply(Arrays.asList(
                new Pair<>("Apple", 2),
                new Pair<>("Orange", 1)));

        HashSet<Pair<String, Integer>> productListing = new HashSet<>(safeway.getProducts());

        /* Purchase three apples, should only get two */
        Collection<Pair<String, Integer>> purchase = safeway.purchase(new Pair<>("Apple", 3));
        Collection<Pair<String, Integer>> expectedPurchase = Arrays.asList(new Pair<>("Apple", 2));
        assertEquals(expectedPurchase, purchase);

        /* Purchase a nonexistent product, should get nothing */
        purchase = safeway.purchase(new Pair<>("Phased Plasma Rifle (40 Watt Range)", 1));
        expectedPurchase = Arrays.asList();
        assertEquals(expectedPurchase, purchase);

        /* Zero apples and one orange should remain. */
        HashSet<Pair<String, Integer>> productSet = new HashSet<>(safeway.getProducts());
        assertTrue(productSet.contains(new Pair<>("Orange", 1)));
        assertTrue(productSet.contains(new Pair<>("Apple", 0)));
    }
}
