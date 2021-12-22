package entities;


/**
 * This class represents an item that has a name and quantity.
 */
public class Item implements Comparable<Item> {
	private final String name;
	private int quantity;

	/**
	 * Initialize an Item with the given name and quantity.
	 *
	 * @param name 		name of item.
	 * @param quantity 	quantity of item.
	 */
	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}	

	/**
	 * Return the name of the item.
	 *
	 * @return name of the item.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the quantity of the item.
	 *
	 * @return quantity of the item.
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Update the quantity of the item by adding the given newAmount.
	 *
	 * @param newAmount the amount being added to the item quantity.
	 */
	public void updateQuantity(int newAmount) {
		this.quantity += newAmount;
	}

	/**
	 * Compare this item with the given item.
	 *
	 * @param item the item being compared to.
	 * @return the result of the comparison
	 */
	@Override
	public int compareTo(Item item) {
		if (item instanceof FoodItem) {
			// FoodItem always comes before Item
			return 1; // Positive number means given FoodItem comes before this Item
		} else {
			return this.name.compareTo(item.name);  // Used to sort alphabetically by name
		}
	}

	/**
	 * Return a string representation of the item.
	 *
	 * @return a string representation of the item.
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + " Quantity: " + this.quantity;
	}
}
  
