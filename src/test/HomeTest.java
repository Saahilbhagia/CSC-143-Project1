package test;

import lib.TestRunner;
import org.junit.Before;
import org.junit.Test;
import world.Home;
import world.Residential;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HomeTest {
    Residential home;

    @Before
    public void setUp() {
        home = new Home("Abbey Road");
    }

    @Test
    public void HomeConstructorTest() {
        Home home = new Home("Abbey Road");
        assertTrue(true);
    }

    @Test
    public void HomeEmptyTest() {
        TestRunner.assertCollectionEquals(Arrays.asList(), home.getOccupants());
    }

    @Test
    public void HomeMoveInTest() {
        home.moveIn("John");
        TestRunner.assertCollectionEquals(Arrays.asList("John"), home.getOccupants());
    }

    @Test
    public void HomeIsOccupiedTest() {
        home.moveIn("John");
        home.moveIn("Paul");
        TestRunner.assertCollectionEquals(Arrays.asList("John"), home.getOccupants());
    }

    @Test
    public void HomeMoveOutTest() {
        home.moveIn("John");
        home.moveOut("John");
        TestRunner.assertCollectionEquals(Arrays.asList(), home.getOccupants());
    }

    @Test
    public void HomeMoveOutWrongResidentTest() {
        home.moveIn("John");
        home.moveOut("Paul");
        TestRunner.assertCollectionEquals(Arrays.asList("John"), home.getOccupants());
    }

    @Test
    public void HomeMoveInAndOutTest() {
        home.moveIn("John");
        TestRunner.assertCollectionEquals(Arrays.asList("John"), home.getOccupants());
        home.moveOut("John");
        TestRunner.assertCollectionEquals(Arrays.asList(), home.getOccupants());
        home.moveIn("Paul");
        TestRunner.assertCollectionEquals(Arrays.asList("Paul"), home.getOccupants());
        home.moveOut("Paul");
        TestRunner.assertCollectionEquals(Arrays.asList(), home.getOccupants());
    }
}
