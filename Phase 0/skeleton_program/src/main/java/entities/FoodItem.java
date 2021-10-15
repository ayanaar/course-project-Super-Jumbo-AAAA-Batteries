package entities;


/**
 * This class represents a food item that has a name, quantity
 * and expiry date.
 */
public class FoodItem extends Item {
	private int expiryDate;

	/**
	* Initialize a FoodItem with the given name, quantity,
	* and expiry date.
	*
	* @param name          name of food item.
	* @param quantity      quantity of food item.
	* @param expiryDate    expiry date of the food item.
	*/
	public FoodItem(String name, int quantity, int expiryDate) {
		super(name, quantity);
		this.expiryDate = expiryDate;
	}

	/**
	* Return the expiry date of the food item.
	*
	* @return the expiry date of the food item.
	*/
	public int getExpiryDate() {
		return this.expiryDate;
	}

	/**
	* Update the expiry date of the food item (decrease by one day).
	*/
	public void updateExpiryDate() {
		this.expiryDate -= 1;
	}

	/**
	* Return a string representation of the food item.
	*
	* @return a string representation of the food item.
	*/
	@Override
	public String toString() {
		return "Name: " + super.getName() + " Quantity: " + super.getQuantity() +
			" Expiry Date: " + this.expiryDate;
	}
}
