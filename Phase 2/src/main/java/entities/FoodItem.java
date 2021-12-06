package entities;

import java.time.LocalDate;


/**
 * This class represents a food item that has a name, quantity
 * and expiry date.
 */
public class FoodItem extends Item {
	private final LocalDate expiryDate;

	/**
	 * Initialize a FoodItem with the given name, quantity,
	 * and expiry date.
	 *
	 * @param name          name of food item.
	 * @param quantity      quantity of food item.
	 * @param expiryDate    expiry date of the food item.
	 */
	public FoodItem(String name, int quantity, LocalDate expiryDate) {
		super(name, quantity);
		this.expiryDate = expiryDate;
	}

	/**
	 * Return the expiry date of the food item.
	 *
	 * @return the expiry date of the food item.
	 */
	public LocalDate getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * Return a string representation of the food item.
	 *
	 * @return a string representation of the food item.
	 */
	@Override
	public String toString() {
		return "Name: " + super.getName() + " Quantity: " + super.getQuantity() +
			" Expiry Date: " + this.expiryDate.toString();  // Expiry date has format YYYY-MM-DD
	}
}
