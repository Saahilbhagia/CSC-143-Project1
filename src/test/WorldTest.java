/*
package test;

import lib.Pair;
import lib.TestRunner;
import org.junit.Before;
import org.junit.Test;
import world.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class WorldTest {
    ArrayList<Building> seattle;

    @Before
    public void setUp() {
        seattle = new ArrayList<>();

        ArrayList<Store> storeList = new ArrayList<>();

        Supermarket buyNLarge = new Supermarket("2008 Wall St", "Buy 'N Large");
        buyNLarge.supply(Arrays.asList(new Pair<>("Apples", 2),
            new Pair<>("Oranges", 2),
            new Pair<>("Peaches", 4)));
        storeList.add(buyNLarge);

        Restaurant pizzaPlanet = new Restaurant("2012 Mars", "Pizza Planet");
        pizzaPlanet.supply(Arrays.asList(new Pair<>("Dough", 2),
                new Pair<>("Sauce", 2),
                new Pair<>("Cheese", 4)));
        pizzaPlanet.learnRecipe("Pizza",
                Arrays.asList(new Pair<>("Dough", 1),
                        new Pair<>("Sauce", 1),
                        new Pair<>("Cheese", 2)));
        storeList.add(pizzaPlanet);

        seattle.addAll(storeList);

        ArrayList<Building> residentialList = new ArrayList<>();

        */
/*
        We could store these as a list of Residential building instead,
        but because Residential is an interface outside of the Property hierarchy,
        we would have to cast each Residential to a (Property) to install them
        in Seattle. This is just easier for our current use case.
         *//*

        //ArrayList<Residential> residentialList = new ArrayList<>();

        Home mansion = new Home("117 Bleecker St");
        mansion.moveIn("Steven Strange");

        residentialList.add(mansion);

        Hotel watergate = new Hotel("2650 Virginia Ave", "The Watergate Hotel");
        watergate.registerRental("Richard Nixon");
        watergate.moveIn("Richard Nixon");
        watergate.registerRental("Bob Woodward");
        watergate.moveIn("Bob Woodward");

        residentialList.add(watergate);

        seattle.addAll(residentialList);
    }

    @Test
    public void LocationTest() {
        ArrayList<String> expectedLocations = new ArrayList();
        expectedLocations.add("2008 Wall St");
        expectedLocations.add("2012 Mars");
        expectedLocations.add("117 Bleecker St");
        expectedLocations.add("2650 Virginia Ave");

        for (int i = 0; i < expectedLocations.size(); ++i) {
            assertEquals(expectedLocations.get(i), seattle.get(i).getLocation());
        }
    }

    @Test
    public void BusinessTest() {
        ArrayList<String> expectedBusinessNames = new ArrayList();
        expectedBusinessNames.add("Buy 'N Large");
        expectedBusinessNames.add("Pizza Planet");
        expectedBusinessNames.add("The Watergate Hotel");

        ArrayList<Business> seattleBusinesses = new ArrayList<>();
        for (Building building : seattle) {
            if (building instanceof Business) {
                seattleBusinesses.add((Business) building);
            }
        }

        for (int i = 0; i < expectedBusinessNames.size(); ++i) {
            assertEquals(expectedBusinessNames.get(i),
                    seattleBusinesses.get(i).getCompany());
        }
    }

    @Test
    public void ResidentialTest() {
        ArrayList<Collection<String>> expectedResidents = new ArrayList<>();
        expectedResidents.add(Arrays.asList("Steven Strange"));
        expectedResidents.add(Arrays.asList("Richard Nixon", "Bob Woodward"));

        ArrayList<Residential> seattleResidential = new ArrayList<>();
        for (Building building : seattle) {
            if (building instanceof Residential) {
                seattleResidential.add((Residential) building);
            }
        }

        for (int i = 0; i < expectedResidents.size(); ++i) {
            TestRunner.assertCollectionEquals(expectedResidents.get(i), seattleResidential.get(i).getOccupants());
        }
    }

    @Test
    public void StoreTest() {
        ArrayList<Collection<Pair<String, Integer>>> expectedProducts = new ArrayList<>();
        expectedProducts.add(Arrays.asList(new Pair<>("Apples", 2),
            new Pair<>("Oranges", 2),
            new Pair<>("Peaches", 4)));

        expectedProducts.add(Arrays.asList(new Pair<>("Pizza", 2)));

        ArrayList<Store> seattleStores = new ArrayList<>();
        for (Building building : seattle) {
            if (building instanceof Store) {
                seattleStores.add((Store) building);
            }
        }

        for (int i = 0; i < expectedProducts.size(); ++i) {
            assertEquals(expectedProducts.get(i), seattleStores.get(i).getProducts());
        }
    }
}*/
