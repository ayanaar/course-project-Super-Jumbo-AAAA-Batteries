package entities;

import helpers.Sorter;
import helpers.TimSorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the ShoppingList class.
 */
public class ShoppingListTest {
    ShoppingList shoppingList;

    /**
     * Set up for testing ShoppingList class.
     */
    @Before
    public void setUp() {
        Sorter<Item> sorter = new TimSorter<>();
        shoppingList = new ShoppingList(sorter);
    }

    /**
     * Test that the getSize() method returns the correct size of
     * the shopping list.
     */
    @Test(timeout = 100)
    public void testGetSize() {
        assertEquals(0, shoppingList.getSize());
    }

    /**
     * Test that the getItem() method returns the correct item from
     * the shopping list.
     */
    @Test(timeout = 100)
    public void testGetItem() {
        Item item = new Item("bread", 99);
        shoppingList.addItem(item);
        assertEquals(item, shoppingList.getItem(0));
    }

    /**
     * Test that the toString() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testToString() {
        shoppingList.addItem(new Item("bread", 99));
        assertEquals("0. Name: bread Quantity: 99", shoppingList.toString());
    }

    /**
     * Test that the addItem() method adds the items to the shopping list successfully.
     */
    @Test(timeout = 200)
    public void testAddItem() {
        shoppingList.addItem(new Item("bread", 99));
        shoppingList.addItem(new Item("toilet paper", 10));
        assertEquals("0. Name: bread Quantity: 99\n" +
                "1. Name: toilet paper Quantity: 10", shoppingList.toString());
    }

    /**
     * Test that the removeItem() method removes an item in the shopping list successfully.
     */
    @Test(timeout = 200)
    public void testRemoveItem() {
        shoppingList.addItem(new Item("bread", 99));
        shoppingList.addItem(new Item("toilet paper", 10));
        shoppingList.removeItem(0);
        assertEquals("0. Name: toilet paper Quantity: 10", shoppingList.toString());
    }

    /**
     * Test that the sortItems() method sorts in the items in the shopping list successfully.
     */
    @Test(timeout = 200)
    public void testSortItems() {
        shoppingList.addItem(new Item("b", 101));
        shoppingList.addItem(new Item("c", 123));
        shoppingList.addItem(new Item("a", 444));
        shoppingList.sortItems();
        assertEquals("0. Name: a Quantity: 444\n" +
                "1. Name: b Quantity: 101\n" +
                "2. Name: c Quantity: 123", shoppingList.toString());
    }
}
