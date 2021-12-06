package use_cases;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the ShoppingListUseCases class.
 */
public class ShoppingListUseCasesTest {
    ShoppingListUseCases shoppingListUseCases;

    /**
     * Set up for testing ShoppingListUseCases class.
     */
    @Before
    public void setUp() {
        shoppingListUseCases = new ShoppingListUseCases();
    }

    /**
     * Test that the addShoppingListItem() method adds an item to the shoppingListUseCases correctly.
     */
    @Test(timeout = 100)
    public void testAddShoppingListItem() {
        shoppingListUseCases.addShoppingListItem("detergent", 101);
        shoppingListUseCases.addShoppingListItem("glue", 444);
        assertEquals("0. Name: detergent Quantity: 101\n" +
                "1. Name: glue Quantity: 444", shoppingListUseCases.returnShoppingList());
    }

    /**
     * Test that the removeShoppingListItem() method removes an item in the shoppingListUseCases correctly.
     */
    @Test(timeout = 200)
    public void testRemoveShoppingListItem() {
        shoppingListUseCases.addShoppingListItem("detergent", 101);
        shoppingListUseCases.addShoppingListItem("glue", 444);
        shoppingListUseCases.removeShoppingListItem(0);
        assertEquals("0. Name: glue Quantity: 444", shoppingListUseCases.returnShoppingList());
    }

    /**
     * Test that the returnShoppingList() method returns the correct string representation.
     */
    @Test(timeout = 100)
    public void testReturnShoppingList() {
        shoppingListUseCases.addShoppingListItem("detergent", 101);
        assertEquals("0. Name: detergent Quantity: 101", shoppingListUseCases.returnShoppingList());
    }

    /**
     * Test that the sortShoppingList() method sorts the shopping list successfully.
     */
    @Test(timeout = 200)
    public void testSortInventory() {
        shoppingListUseCases.addShoppingListItem("b", 444);
        shoppingListUseCases.addShoppingListItem("c", 123);
        shoppingListUseCases.addShoppingListItem("a", 101);
        shoppingListUseCases.sortShoppingList();
        assertEquals("0. Name: a Quantity: 101\n" +
                "1. Name: b Quantity: 444\n" +
                "2. Name: c Quantity: 123", shoppingListUseCases.returnShoppingList());
    }
}