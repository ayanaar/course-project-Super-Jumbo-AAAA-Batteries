package entities;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a user's inventory.
 */
public class InventoryList {
	private final List<Item> inventory;

	/**
	 * Initialize an empty inventory.
	 */
	public InventoryList() {
		this.inventory = new ArrayList<>();
	}

	/**
	 * Add the given item to the user's inventory.
	 *
	 * @param item the item being added to the user's inventory.
	 */
	public void addItem(Item item) {
		this.inventory.add(item);
	}

	/**
	 * Remove the item at the given index from the user's inventory.
	 *
	 * @param index the index of the  item to be removed.
	 */
	public void removeItem(int index) {
		this.inventory.remove(index);
	}

	/**
	 * Update the quantity of the item at the given index in the user's inventory.
	 *
	 * @param index       index of item being updated.
	 * @param newAmount   addition amount being added to quantity.
	 */
	public void updateQuantity(int index, int newAmount) {
		Item item = this.inventory.get(index);
		item.updateQuantity(newAmount);
	}

	/**
	 * Return a string representation of the user's inventory.
	 *
	 * @return a string representation of the user's inventory.
	 */
	@Override
	public String toString() {
		StringBuilder stringRepresentation = new StringBuilder();

		// Loop thorough each item in the inventory
		for (int i = 0; i < this.inventory.size(); i++) {
			// Number each item 0, 1, 2, etc. + their string representation
			String itemOption = i + ". " + this.inventory.get(i).toString() + "\n";
			stringRepresentation.append(itemOption);   // Append item to inventory representation
		}

		return stringRepresentation.toString().trim();  // Trim off last \n
	}

	/**
	 * Return a string representation of the user's inventory.
	 *
	 * @return a string representation of the user's inventory.
	 */
	public StringBuilder toStringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("index,item name,quantity,expiry date\r\n");
		Item item;

		// Loop through each item in the inventory
		for (int i = 0; i < this.inventory.size(); i++) {
			item = this.inventory.get(i); // Get item
			sb.append(i).append(","); // Add index
			sb.append(item.getName()).append(",");  // Add item name
			sb.append(item.getQuantity()).append(","); // Add quantity

			if (item instanceof FoodItem) {
				sb.append(((FoodItem) item).getExpiryDate()); // Add expiry date
			}

			sb.append("\r\n");
		}

		return sb;
	}
}
