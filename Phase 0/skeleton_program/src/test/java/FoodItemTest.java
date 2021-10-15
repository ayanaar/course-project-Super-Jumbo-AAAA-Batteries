import entities.FoodItem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * This class tests the FoodItem class.
 */
public class FoodItemTest {
  	FoodItem foodItem;

  	/**
     * Set up for testing FoodItem class.
     */
    @Before
    public void setUp(){
        foodItem = new FoodItem("bread", 99, 7);
    }

    /**
     * Test that the toString method returns the expected string representation.
     */
    @Test(timeout = 100)
    public void testToString() {
        assertEquals("Name: bread Quantity: 99 Expiry Date: 7", foodItem.toString());
    }

    /**
     * Test that the updateExpiryDate() method updates the expected item expiry date to the correct date.
     */
    @Test(timeout = 100)
    public void testUpdateExpiryDate() {
        foodItem.updateExpiryDate();
        assertEquals(6, foodItem.getExpiryDate());
    }
}
