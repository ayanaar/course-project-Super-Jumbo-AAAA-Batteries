package entities;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the Item class.
 */
public class ItemTest {
    Item item;

    /**
     * Set up for testing Item class.
     */
    @Before
    public void setUp() {
        item = new Item("toilet paper", 99);
    }

    /**
     * Test that the getName() method returns the Item's name.
     */
    @Test(timeout = 100)
    public void testGetName() {
        assertEquals("toilet paper", item.getName());
    }

    /**
     * Test that the getQuantity() method returns the Item's quantity.
     */
    @Test(timeout = 100)
    public void testGetQuantity() {
        assertEquals(99, item.getQuantity());
    }

    /**
     * Test that the updateQuantity() method updates the item quantity to the expected amount.
     */
    @Test(timeout = 100)
    public void testUpdateQuantity() {
        item.updateQuantity(10);
        assertEquals(109, item.getQuantity());
    }

    /**
     * Test that the compareTo() method returns the correct output
     * when comparing to Item.
     */
    @Test(timeout = 100)
    public void testCompareToItem() {
        assertEquals("toilet paper".compareTo("banana"),
                item.compareTo(new Item("banana", 12)));
    }

    /**
     * Test that the compareTo() method returns the correct output
     * when comparing to FoodItem.
     */
    @Test(timeout = 100)
    public void testCompareToFoodItem() {
        assertEquals(1, item.compareTo(
                new FoodItem("banana", 12, LocalDate.parse("2020-12-12"))));
    }

    /**
     * Test that the toString() method returns the expected string representation.
     */
    @Test(timeout = 100)
    public void testToString() {
        assertEquals("Name: toilet paper Quantity: 99", item.toString());
    }
}