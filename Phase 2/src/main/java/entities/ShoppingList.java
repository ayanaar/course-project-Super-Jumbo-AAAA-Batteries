package entities;

import java.util.List;
import java.util.ArrayList;


/**
 * This class represents a user's shopping list.
 */
public class ShoppingList {
	private final List<Item> shoppingList;

	/**
	 * Initialize a new empty shopping list.
	 */
	public ShoppingList() {
		this.shoppingList = new ArrayList<>();
	}

	/**
	 * Add the given item to the shopping list.
	 *
	 * @param item the item being added to the shopping list.
	 */
	public void addItem(Item item) {
		this.shoppingList.add(item);
	}

	/**
	 * Remove the item at the given index from the shopping list.
	 *
	 * @param index the index of the item being removed.
	 */
	public void removeItem(int index) {
		this.shoppingList.remove(index);
	}

	/**
	 * Return a string representation of the user's shopping list.
	 *
	 * @return a string representation of the user's shopping list.
	 */
	@Override
	public String toString() {
		StringBuilder stringRepresentation = new StringBuilder();

		// Loop thorough each item in the shopping list
		for (int i = 0; i < this.shoppingList.size(); i++) {
			// Number each item 0, 1, 2, etc. + their string representation
			String itemOption = i + ". " + this.shoppingList.get(i).toString() + "\n";
			stringRepresentation.append(itemOption);   // Append item to shopping list representation
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
		sb.append("index,item name,quantity\r\n");
		Item item;

		// Loop through each item in the inventory
		for (int i = 0; i < this.shoppingList.size(); i++) {
			item = this.shoppingList.get(i); // Get item
			sb.append(i).append(","); // Add index
			sb.append(item.getName()).append(",");  // Add item name
			sb.append(item.getQuantity()); // Add quantity
			sb.append("\r\n");
		}

		return sb;
	}
}
