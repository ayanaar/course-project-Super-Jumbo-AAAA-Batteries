package controllers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;


/**
 * This class tests the ListManager class.
 */
public class ListManagerTest {
    ListManager listManager;

    /**
     * Set up for testing ListManager class.
     */
    @Before
    public void setUp() {
        InventoryUseCases inventoryUseCases = new InventoryUseCases();
        ShoppingListUseCases shoppingListUseCases = new ShoppingListUseCases();
        listManager = new ListManager(inventoryUseCases, shoppingListUseCases);
    }

    /**
     * Test that the addInventoryItem() method adds the items to the inventory correctly.
     */
    @Test(timeout = 100)
    public void testAddInventoryItem() {
        listManager.addInventoryItem("detergent", 101, "2021-12-10");
        listManager.addInventoryItem("glue", 444, "2021-12-10");
        assertEquals("0. Name: detergent Quantity: 101 Expiry Date: 2021-12-10\n" +
                "1. Name: glue Quantity: 444 Expiry Date: 2021-12-10", listManager.printInventory());
    }

    /**
     * Test that the removeInventoryItem() method removes an item from the inventory correctly.
     */
    @Test(timeout = 100)
    public void testRemoveInventoryItem() {
        listManager.addInventoryItem("detergent", 101, "2021-12-10");
        listManager.addInventoryItem("glue", 444, "2021-12-10");
        listManager.removeInventoryItem(0);
        assertEquals("0. Name: glue Quantity: 444 Expiry Date: 2021-12-10", listManager.printInventory());
    }

    /**
     * Test that the printInventory() method returns the correct string representation.
     */
    @Test(timeout = 200)
    public void testPrintInventory() {
        listManager.addInventoryItem("detergent", 101, "2021-12-10");
        assertEquals("0. Name: detergent Quantity: 101 Expiry Date: 2021-12-10", listManager.printInventory());
    }

    /**
     * Test that the addShoppingListItem() method adds the items to the shopping list correctly.
     */
    @Test(timeout = 100)
    public void testAddShoppingListItem() {
        listManager.addShoppingListItem("detergent", 101);
        listManager.addShoppingListItem("glue", 444);
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: glue Quantity: 444", listManager.printShoppingList());
    }

    /**
     * Test that the removeShoppingListItem() method removes an item from the inventory correctly.
     */
    @Test(timeout = 100)
    public void testRemoveShoppingListItem() {
        listManager.addShoppingListItem("detergent", 101);
        listManager.addShoppingListItem("glue", 444);
        listManager.removeShoppingListItem(1);
        assertEquals("0. Name: detergent Quantity: 101", listManager.printShoppingList());
    }

    /**
     * Test that the printShoppingList() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testPrintShoppingList() {
        listManager.addShoppingListItem("detergent", 101);
        listManager.addShoppingListItem("glue", 444);
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: glue Quantity: 444", listManager.printShoppingList());
    }

    /**
     * Test that the sortList() method sorts the inventory correctly.
     */
    @Test(timeout = 200)
    public void testSortListInventory() {
        listManager.addInventoryItem("b", 101, "2021-12-10");
        listManager.addInventoryItem("c", 444, "2021-12-11");
        listManager.addInventoryItem("a", 123, "");
        listManager.sortLists();
        assertEquals("0. Name: b Quantity: 101 Expiry Date: 2021-12-10\n" +
                "1. Name: c Quantity: 444 Expiry Date: 2021-12-11\n" +
                "2. Name: a Quantity: 123", listManager.printInventory());
    }

    /**
     * Test that the sortList() method sorts the shopping list correctly.
     */
    @Test(timeout = 200)
    public void testSortListShoppingList() {
        listManager.addShoppingListItem("b", 101);
        listManager.addShoppingListItem("c", 123);
        listManager.addShoppingListItem("a", 444);
        listManager.sortLists();
        assertEquals("0. Name: a Quantity: 444\n" +
                "1. Name: b Quantity: 101\n" +
                "2. Name: c Quantity: 123", listManager.printShoppingList());
    }
}
