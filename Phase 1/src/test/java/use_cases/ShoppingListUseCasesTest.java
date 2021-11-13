package use_cases;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingListUseCasesTest {

    /**
     * This class tests the ShoppingListUseCases class.
     */
    ShoppingListUseCases inventory;

    /**
     * Set up for testing ShoppingListUseCases class.
     */

    @Before
    public void setUp() {
        inventory = new ShoppingListUseCases();
    }

    /**
     * Test that the addShoppingListItem() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testAddShoppingListItem() {
        inventory.addShoppingListItem("detergent", 101);
        inventory.addShoppingListItem("glue", 444);
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: glue Quantity: 444", inventory.returnShoppingList());
    }

    /**
     * Test that the removeShoppingListItem() method removes an item in the inventory successfully.
     */
    @Test(timeout = 200)
    public void testRemoveShoppingListItem() {
        inventory.addShoppingListItem("detergent", 101);
        inventory.addShoppingListItem("glue", 444);
        inventory.removeShoppingListItem(0);
        assertEquals("0. Name: glue Quantity: 444", inventory.returnShoppingList());
    }

    /**
     * Test that the returnShoppingList() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testReturnShoppingList() {
        inventory.addShoppingListItem("detergent", 101);
        assertEquals("0. Name: detergent Quantity: 101", inventory.returnShoppingList());
    }
}


