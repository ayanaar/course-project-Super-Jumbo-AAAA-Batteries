package entities;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a user's inventory.
 */
public class InventoryList implements ItemList {
	private final List<Item> inventory;

	/**
	 * Initialize an empty inventory.
	 */
	public InventoryList() {
		this.inventory = new ArrayList<>();
	}

	/**
	 * Return the number of items in this inventory.
	 *
	 * @return the number of items in this inventory.
	 */
	public int getSize() {
		return this.inventory.size();
	}

	/**
	 * Return the item at the given index.
	 *
	 * @param index the index of the item in this inventory..
	 * @return the item at the given index.
	 */
	public Item getItem(int index) {
		return this.inventory.get(index);
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
}
