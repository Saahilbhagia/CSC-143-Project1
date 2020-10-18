package test;

import org.junit.Before;
import org.junit.Test;
import world.*;

import java.util.Arrays;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HotelTest {
    Residential hotel;

    @Before
    public void setUp() {
        hotel = new Hotel("Abbey Road", "Mariott");
    }

    @Test
    public void HotelConstructorTest() {
        Hotel hotel = new Hotel("Abbey Road", "Mariott");
        assertTrue(true);
    }

    @Test
    public void HotelEmptyTest() {
        assertEquals(new HashSet<String>(Arrays.asList()),
                new HashSet<String>(hotel.getOccupants()));
    }

    @Test
    public void HotelRegistrationTest() {
        Hotel hotel = (Hotel) this.hotel;
        hotel.registerRental("John");
        hotel.moveIn("John");

        assertEquals(new HashSet<String>(Arrays.asList("John")),
                new HashSet<String>(hotel.getOccupants()));
    }

    @Test
    public void HotelMultipleRegistrationTest() {
        Hotel hotel = (Hotel) this.hotel;

        hotel.registerRental("John");
        hotel.moveIn("John");
        hotel.registerRental("Paul");
        hotel.registerRental("Luke");
        hotel.moveIn("Paul");
        hotel.moveIn("Luke");

        assertEquals(new HashSet<String>(Arrays.asList("John", "Paul", "Luke")),
                new HashSet<String>(hotel.getOccupants()));
    }

    @Test
    public void HotelMoveInWithoutRegisteringTest() {
        Hotel hotel = (Hotel) this.hotel;

        hotel.registerRental("John");
        hotel.moveIn("Luke");
        hotel.moveIn("John");

        assertEquals(new HashSet<String>(Arrays.asList("John")),
                new HashSet<String>(hotel.getOccupants()));
    }

    @Test
    public void HotelMoveOutTest() {
        Hotel hotel = (Hotel) this.hotel;

        this.HotelMultipleRegistrationTest();
        hotel.moveOut("Paul");
        hotel.moveOut("John");

        assertEquals(new HashSet<String>(Arrays.asList("Luke")),
                new HashSet<String>(hotel.getOccupants()));
    }

    @Test
    public void HotelEndRentalTest() {
        Hotel hotel = (Hotel) this.hotel;

        this.HotelMultipleRegistrationTest();
        hotel.endRental("Paul");
        hotel.moveOut("John");

        assertEquals(new HashSet<String>(Arrays.asList("Luke")),
                new HashSet<String>(hotel.getOccupants()));

        hotel.endRental("Luke");
        hotel.moveIn("Luke");

        assertEquals(new HashSet<String>(Arrays.asList()), new HashSet<String>(hotel.getOccupants()));
    }
}
