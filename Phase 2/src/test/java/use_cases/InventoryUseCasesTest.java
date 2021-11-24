package use_cases;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the InventoryUseCases class.
 */
public class InventoryUseCasesTest {
    InventoryUseCases inventory;

    /**
     * Set up for testing InventoryUseCases class.
     */
    @Before
    public void setUp() {
        inventory = new InventoryUseCases();
    }

    /**
     * Test that the addInventoryItem() method adds the item to inventory correctly.
     */
    @Test(timeout = 100)
    public void testAddInventoryItem() {
        inventory.addInventoryItem("detergent", 101, "");
        inventory.addInventoryItem("cupcake", 444, "2021-12-10");
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: cupcake Quantity: 444 Expiry Date: 2021-12-10", inventory.returnInventory());
    }

    /**
     * Test that the removeInventoryItem() method removes an item in the inventory correctly.
     */
    @Test(timeout = 200)
    public void testRemoveInventoryItem() {
        inventory.addInventoryItem("detergent", 101, "");
        inventory.addInventoryItem("cupcake", 444, "2021-12-10");
        inventory.removeInventoryItem(0);
        assertEquals("0. Name: cupcake Quantity: 444 Expiry Date: 2021-12-10", inventory.returnInventory());
    }

    /**
     * Test that the returnInventory() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testReturnInventory() {
        inventory.addInventoryItem("detergent", 101, "");
        assertEquals("0. Name: detergent Quantity: 101", inventory.returnInventory());
    }
}