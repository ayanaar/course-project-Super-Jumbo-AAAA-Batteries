package controller;
import org.junit.Before;
import org.junit.Test;
import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;

import static org.junit.Assert.assertEquals;

public class ListManagerTest {
    /**
     * This class tests the ListManager class.
     */
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
     * Test that the addInventoryItem method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testAddShoppingListItem() {
        inventory.addShoppingListItem("detergent", 101);
        inventory.addShoppingListItem("glue", 444);
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: glue Quantity: 444", inventory.returnShoppingList());

    }


}
