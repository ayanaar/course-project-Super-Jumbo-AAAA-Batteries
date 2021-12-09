package entities;

import helpers.Sorter;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a user's inventory.
 */
public class InventoryList implements ItemList {
	private final List<Item> inventory;
	private final Sorter<Item> sorter;

	/**
	 * Initialize an empty inventory.
	 */
	public InventoryList(Sorter<Item> sorter) {
		this.inventory = new ArrayList<>();
		this.sorter = sorter;
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
	 * Sort the items in this inventory.
	 */
	public void sortItems() {
		sorter.sort(this.inventory);
	}
}
