package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * This class represents a food item that has a name, quantity
 * and expiry date.
 */
public class FoodItem extends Item {
	private final LocalDate EXPIRY_DATE;

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
		this.EXPIRY_DATE = expiryDate;
	}

	/**
	 * Return the expiry date of the food item.
	 *
	 * @return the expiry date of the food item.
	 */
	public LocalDate getExpiryDate() {
		return this.EXPIRY_DATE;
	}

	/**
	 * Return true if the number of days until the food item's expiry date
	 * is less than or equal to the given number of days.
	 *
	 * @param days the number of days being compared to
	 * @return true if the number of days until expiry date <= days
	 */
	public boolean compareExpiryDate(int days) {
		LocalDate currentDate = LocalDate.now();
		int difference = (int) currentDate.until(this.EXPIRY_DATE, ChronoUnit.DAYS);
		return difference <= days;
	}

	/**
	 * Return a string representation of the food item.
	 *
	 * @return a string representation of the food item.
	 */
	@Override
	public String toString() {
		return "Name: " + super.getName() + " Quantity: " + super.getQuantity() +
			" Expiry Date: " + this.EXPIRY_DATE.toString();  // Expiry date has format YYYY-MM-DD
	}
}
