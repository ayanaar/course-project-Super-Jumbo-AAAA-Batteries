package entities;

import java.util.List;
import java.util.ArrayList;


/**
 * This class represents a user's shopping list.
 */
public class ShoppingList {
	private final List<Item> SHOPPING_LIST;

	/**
	 * Initialize a new empty shopping list.
	 */
	public ShoppingList() {
		this.SHOPPING_LIST = new ArrayList<>();
	}

	/**
	 * Add the given item to the shopping list.
	 *
	 * @param item the item being added to the shopping list.
	 */
	public void addItem(Item item) {
		this.SHOPPING_LIST.add(item);
	}

	/**
	 * Remove the item at the given index from the shopping list.
	 *
	 * @param index the index of the item being removed.
	 */
	public void removeItem(int index) {
		this.SHOPPING_LIST.remove(index);
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
		for (int i = 0; i < this.SHOPPING_LIST.size(); i++) {
			// Number each item 0, 1, 2, etc. + their string representation
			String itemOption = i + ". " + this.SHOPPING_LIST.get(i).toString() + "\n";
			stringRepresentation.append(itemOption);	// Append item to shopping list representation
		}

		return stringRepresentation.toString().trim();  // Trim off last \n
	}
}
