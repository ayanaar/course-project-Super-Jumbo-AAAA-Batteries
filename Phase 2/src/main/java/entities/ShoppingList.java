package entities;

import helpers.Sorter;

import java.util.List;
import java.util.ArrayList;


/**
 * This class represents a user's shopping list.
 */
public class ShoppingList implements ItemList {
	private final List<Item> shoppingList;
	private final Sorter<Item> sorter;

	/**
	 * Initialize a new empty shopping list.
	 */
	public ShoppingList(Sorter<Item> sorter) {
		this.shoppingList = new ArrayList<>();
		this.sorter = sorter;
	}

	/**
	 * Return the number of items in this shopping list.
	 *
	 * @return the number of items in this shopping list.
	 */
	public int getSize() {
		return this.shoppingList.size();
	}

	/**
	 * Return the item at the given index.
	 *
	 * @param index the index of the item in this shopping list.
	 * @return the item at the given index.
	 */
	public Item getItem(int index) {
		return this.shoppingList.get(index);
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
	 * Sort the items in this inventory.
	 */
	public void sortItems() {
		sorter.sort(this.shoppingList);
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
}
