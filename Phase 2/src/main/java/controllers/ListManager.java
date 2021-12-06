package controllers;

import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;


/**
 * This class manages the user's inventory and shopping list.
 */
public class ListManager {
	private final InventoryUseCases inventoryUseCases;
	private final ShoppingListUseCases shoppingListUseCases;

	/**
	 * Initialize a ListManager by setting up the user's
	 * inventory and shopping list.
	 */
	public ListManager(InventoryUseCases inventoryUseCases, ShoppingListUseCases shoppingListUseCases) {
		this.inventoryUseCases = inventoryUseCases;
		this.shoppingListUseCases = shoppingListUseCases;
	}

	/**
	 * Return the user's inventory that will be printed to the user.
	 *
	 * @return the user's inventory.
	 */
	public String printInventory() {
		return inventoryUseCases.returnInventory();
	}

	/**
	 * Add the given item (name, quantity, and possibly expiry date) to
	 * the user's inventory.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 * @param expiryDate    the expiry date of the item being added (YYYY-MM-DD).
	 */
	public void addInventoryItem(String name, int quantity, String expiryDate) {
		inventoryUseCases.addInventoryItem(name, quantity, expiryDate);
	}

	/**
	 * Remove the item at the given index from the user's inventory.
	 *
	 * @param index the index of the item to be removed.
	 */
	public void removeInventoryItem(int index) {
		inventoryUseCases.removeInventoryItem(index);
	}

	/**
	 * Return the user's shopping list that will be printed to the user.
	 *
	 * @return the user's shopping list.
	 */
	public String printShoppingList() {
		return shoppingListUseCases.returnShoppingList();
	}

	/**
	 * Add the given item (name and quantity) to the user's shopping list.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 */
	public void addShoppingListItem(String name, int quantity) {
		shoppingListUseCases.addShoppingListItem(name, quantity);
	}

	/**
	 * Remove the item at the given index from the user's shopping list.
	 *
	 * @param index the index of the item to be removed.
	 */
	public void removeShoppingListItem(int index) {
		shoppingListUseCases.removeShoppingListItem(index);
	}

	/**
	 * Save both the inventory list and the shopping list of the user for later use.
	 *
	 * @param user the username of the user that program is handling the session of
	 */
	public void saveLists(String user) {
		inventoryUseCases.saveList(user);
		shoppingListUseCases.saveList(user);
	}
}
