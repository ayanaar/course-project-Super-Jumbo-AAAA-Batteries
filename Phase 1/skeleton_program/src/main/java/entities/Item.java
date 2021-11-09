package entities;


/**
 * This class represents an item that has a name and quantity.
 */
public class Item {
	private final String NAME;
	private int quantity;

	/**
	 * Initialize an Item with the given name and quantity.
	 *
	 * @param name 		name of item.
	 * @param quantity 	quantity of item.
	 */
	public Item(String name, int quantity) {
		this.NAME = name;
		this.quantity = quantity;
	}	

	/**
	 * Return the name of the item.
	 *
	 * @return name of the item.
	 */
	public String getName() {
		return this.NAME;
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
	 * Return a string representation of the item.
	 *
	 * @return a string representation of the item.
	 */
	@Override
	public String toString() {
		return "Name: " + this.NAME + " Quantity: " + this.quantity;
	}
}
  
