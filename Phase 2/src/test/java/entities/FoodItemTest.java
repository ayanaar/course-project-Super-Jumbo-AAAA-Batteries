package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * This class tests the FoodItem class.
 */
public class FoodItemTest {
    FoodItem foodItem;
    LocalDate expiryDate;

    /**
     * Set up for testing FoodItem class.
     */
    @Before
    public void setUp() {
        // Set expiry date to 10 days ahead of today's date
        expiryDate = LocalDate.now().plus(10, ChronoUnit.DAYS);
        foodItem = new FoodItem("bread", 99, expiryDate);
    }

    /**
     * Test that the getExpiryDate() method returns the FoodItem's expiry date.
     */
    @Test(timeout = 100)
    public void testGetExpiryDate() {
        assertEquals(expiryDate, foodItem.getExpiryDate());
    }

    /**
     * Test that the compareExpiryDate() method returns false.
     */
    @Test(timeout = 100)
    public void testCompareExpiryDateFalse() {
        // Check if expiry date is within 7 days of today
        assertFalse(foodItem.compareExpiryDate(7));
    }

    /**
     * Test that the compareExpiryDate() method returns true.
     */
    @Test(timeout = 100)
    public void testCompareExpiryDateTrue() {
        // Check if expiry date is within 10 days of today
        assertTrue(foodItem.compareExpiryDate(10));
    }

    /**
     * Test that the toString() method returns the expected string representation.
     */
    @Test(timeout = 100)
    public void testToString() {
        assertEquals("Name: bread Quantity: 99 Expiry Date: " + expiryDate.toString(), foodItem.toString());
    }
}
