package entities;

import helpers.Sorter;
import helpers.TimSorter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the InventoryList class.
 */
public class InventoryListTest {
    InventoryList inventory;

    /**
     * Set up for testing InventoryList class.
     */
    @Before
    public void setUp() {
        Sorter<Item> sorter = new TimSorter<>();
        inventory = new InventoryList(sorter);
    }

    /**
     * Test that the getSize() method returns the correct size of the inventory.
     */
    @Test(timeout = 100)
    public void testGetSize() {
        assertEquals(0, inventory.getSize());
    }

    /**
     * Test that the getItem() method returns the correct item from the inventory.
     */
    @Test(timeout = 100)
    public void testGetItem() {
        Item item = new FoodItem("bread", 99, LocalDate.parse("2021-12-10"));
        inventory.addItem(item);
        assertEquals(item, inventory.getItem(0));
    }

    /**
     * Test that the toString() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testToString() {
        inventory.addItem(new FoodItem("bread", 99, LocalDate.parse("2021-12-10")));
        assertEquals("0. Name: bread Quantity: 99 Expiry Date: 2021-12-10", inventory.toString());
    }

    /**
     * Test that the addItem() method adds the items to the inventory successfully.
     */
    @Test(timeout = 200)
    public void testAddItem() {
        inventory.addItem(new FoodItem("bread", 99, LocalDate.parse("2021-12-10")));
        inventory.addItem(new Item("toilet paper", 10));
        assertEquals("0. Name: bread Quantity: 99 Expiry Date: 2021-12-10\n" +
                "1. Name: toilet paper Quantity: 10", inventory.toString());
    }

    /**
     * Test that the removeItem() method removes an item in the inventory successfully.
     */
    @Test(timeout = 200)
    public void testRemoveItem() {
        inventory.addItem(new FoodItem("bread", 99, LocalDate.parse("2021-12-10")));
        inventory.addItem(new Item("toilet paper", 10));
        inventory.removeItem(0);
        assertEquals("0. Name: toilet paper Quantity: 10", inventory.toString());
    }

    /**
     * Test that the sortItems() method sorts in the items in the inventory successfully.
     */
    @Test(timeout = 200)
    public void testSortItems() {
        inventory.addItem(new FoodItem("b", 101, LocalDate.parse("2021-12-10")));
        inventory.addItem(new FoodItem("c", 444, LocalDate.parse("2021-12-11")));
        inventory.addItem(new Item("a", 123));
        inventory.sortItems();
        assertEquals("0. Name: b Quantity: 101 Expiry Date: 2021-12-10\n" +
                "1. Name: c Quantity: 444 Expiry Date: 2021-12-11\n" +
                "2. Name: a Quantity: 123", inventory.toString());
    }
}
