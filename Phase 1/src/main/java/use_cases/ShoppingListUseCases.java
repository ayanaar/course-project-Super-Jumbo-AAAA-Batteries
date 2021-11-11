package use_cases;

import entities.ShoppingList;
import entities.Item;


/**
 * This class interacts with the shopping list entities.
 */
public class ShoppingListUseCases {
	private final ShoppingList shoppingList;

	/**
	 * Initialize an empty shopping list.
	 */
	public ShoppingListUseCases() {
		this.shoppingList = new ShoppingList();
	}

	/**
	 * Return the user's shopping list that will be printed to the user.
	 *
	 * @return the user's shopping list.
	 */
	public String returnShoppingList() {
		return this.shoppingList.toString();
	}

	/**
	 * Add the given item (name and quantity) to the user's shopping list.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 */
	public void addShoppingListItem(String name, int quantity) {
		Item item = new Item(name, quantity);
		this.shoppingList.addItem(item);
	}

	/**
	 * Remove the item at the given index from the user's shopping list.
	 *
	 * @param index the index of the item being removed.
	 */
	public void removeShoppingListItem(int index) {
		this.shoppingList.removeItem(index);
	}
}
