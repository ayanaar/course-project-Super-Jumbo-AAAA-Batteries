import entities.Item;

import org.junit.Before;
import org.junit.Test;
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
	 * Test that the toString method returns the expected string representation.
	 */
	@Test(timeout = 100)
	public void testToString() {
		assertEquals("Name: toilet paper Quantity: 99", item.toString());
	}

	/**
	 * Test that the updateQuantity method updates the item quantity to the expected amount.
	 */
	@Test(timeout = 100)
	public void testUpdateQuantity() {
		item.updateQuantity(10);
		assertEquals(109, item.getQuantity());
	}
}
