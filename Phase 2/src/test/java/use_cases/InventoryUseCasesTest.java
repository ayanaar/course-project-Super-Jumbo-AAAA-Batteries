package use_cases;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the InventoryUseCases class.
 */
public class InventoryUseCasesTest {
    InventoryUseCases inventoryUseCases;

    /**
     * Set up for testing InventoryUseCases class.
     */
    @Before
    public void setUp() {
        inventoryUseCases = new InventoryUseCases();
    }

    /**
     * Test that the addInventoryItem() method adds the item to inventoryUseCases correctly.
     */
    @Test(timeout = 100)
    public void testAddInventoryItem() {
        inventoryUseCases.addInventoryItem("detergent", 101, "");
        inventoryUseCases.addInventoryItem("cupcake", 444, "2021-12-10");
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: cupcake Quantity: 444 Expiry Date: 2021-12-10", inventoryUseCases.returnInventory());
    }

    /**
     * Test that the removeInventoryItem() method removes an item in the inventoryUseCases correctly.
     */
    @Test(timeout = 200)
    public void testRemoveInventoryItem() {
        inventoryUseCases.addInventoryItem("detergent", 101, "");
        inventoryUseCases.addInventoryItem("cupcake", 444, "2021-12-10");
        inventoryUseCases.removeInventoryItem(0);
        assertEquals("0. Name: cupcake Quantity: 444 Expiry Date: 2021-12-10", inventoryUseCases.returnInventory());
    }

    /**
     * Test that the returnInventory() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testReturnInventory() {
        inventoryUseCases.addInventoryItem("detergent", 101, "");
        assertEquals("0. Name: detergent Quantity: 101", inventoryUseCases.returnInventory());
    }

    /**
     * Test that the sortInventory() method sorts the inventory successfully.
     */
    @Test(timeout = 200)
    public void testSortInventory() {
        inventoryUseCases.addInventoryItem("b", 101, "2021-12-10");
        inventoryUseCases.addInventoryItem("c", 444, "2021-12-11");
        inventoryUseCases.addInventoryItem("a", 123, "");
        inventoryUseCases.sortInventory();
        assertEquals("0. Name: b Quantity: 101 Expiry Date: 2021-12-10\n" +
                "1. Name: c Quantity: 444 Expiry Date: 2021-12-11\n" +
                "2. Name: a Quantity: 123", inventoryUseCases.returnInventory());
    }
}