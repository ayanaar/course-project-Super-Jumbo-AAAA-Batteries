package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a user's inventory.
 */
public class InventoryList {
	private final List<Item> INVENTORY;

	/**
	 * Initialize an empty inventory.
	 */
	public InventoryList() {
		this.INVENTORY = new ArrayList<>();
	}

	/**
	 * Add the given item to the user's inventory.
	 *
	 * @param item the item being added to the user's inventory.
	 */
	public void addItem(Item item) {
		this.INVENTORY.add(item);
	}

	/**
	 * Remove the item at the given index from the user's inventory.
	 *
	 * @param index the index of the  item to be removed.
	 */
	public void removeItem(int index) {
		this.INVENTORY.remove(index);
	}

	/**
	 * Update the quantity of the item at the given index in the user's inventory.
	 *
	 * @param index       index of item being updated.
	 * @param quantity     quantity of item being updated.
	 */
	public void updateQuantity(int index, int quantity) {
		Item item = this.INVENTORY.get(index);
		item.updateQuantity(quantity);
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
		for (int i = 0; i < this.INVENTORY.size(); i++) {
			// Number each item 0, 1, 2, etc. + their string representation
			String itemOption = i + ". " + this.INVENTORY.get(i).toString() + "\n";
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

		sb.append("index");
		sb.append(",");
		sb.append("item name");
		sb.append(",");
		sb.append("quantity");
		sb.append(",");
		sb.append("expiry date");
		sb.append("\r\n");

		// Loop thorough each item in the inventory
		for (int i = 0; i < this.INVENTORY.size(); i++) {
			// Get the corresponding items corresponding values and assign an index
			String itemIndex = String.valueOf(i);
			String itemName = this.INVENTORY.get(i).getName();
			String itemQuantity = String.valueOf(this.INVENTORY.get(i).getQuantity());
			String itemExpiryDate;
			if (this.INVENTORY.get(i) instanceof FoodItem) {
				itemExpiryDate = (((FoodItem) this.INVENTORY.get(i)).getExpiryDate()).toString();
			} else {
				itemExpiryDate = "";
			}
			sb.append(itemIndex);
			sb.append(",");
			sb.append(itemName);
			sb.append(",");
			sb.append(itemQuantity);
			sb.append(",");
			sb.append(itemExpiryDate);
			sb.append("\r\n"); }

		return sb;
	}
}
