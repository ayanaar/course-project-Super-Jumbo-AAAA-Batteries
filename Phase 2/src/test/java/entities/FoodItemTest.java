package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
     * Test that the compareTo() method returns the correct output
     * when comparing to Item.
     */
    @Test(timeout = 100)
    public void testCompareToItem() {
        assertEquals(-1, foodItem.compareTo(new Item("banana", 12)));
    }

    /**
     * Test that the compareTo() method returns the correct output
     * when comparing to FoodItem.
     */
    @Test(timeout = 100)
    public void testCompareToFoodItem() {
        assertEquals(2, foodItem.compareTo(
                new FoodItem("banana", 12, expiryDate.minus(2, ChronoUnit.DAYS))));
    }

    /**
     * Test that the toString() method returns the expected string representation.
     */
    @Test(timeout = 100)
    public void testToString() {
        assertEquals("Name: bread Quantity: 99 Expiry Date: " + expiryDate.toString(), foodItem.toString());
    }
}
