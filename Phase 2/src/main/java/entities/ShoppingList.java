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
}