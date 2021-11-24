package controller;

import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;


/**
 * This class manages the user's inventory and shopping list.
 */
public class ListManager {
	private final InventoryUseCases INVENTORY_USE_CASES;
	private final ShoppingListUseCases SHOPPING_LIST_USE_CASES;

	/**
	 * Initialize a ListManager by setting up the user's
	 * inventory and shopping list.
	 */
	public ListManager(InventoryUseCases inventoryUseCases, ShoppingListUseCases shoppingListUseCases) {
		this.INVENTORY_USE_CASES = inventoryUseCases;
		this.SHOPPING_LIST_USE_CASES = shoppingListUseCases;
	}

	/**
	 * Return the user's inventory that will be printed to the user.
	 *
	 * @return the user's inventory.
	 */
	public String printInventory() {
		return INVENTORY_USE_CASES.returnInventory();
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
		INVENTORY_USE_CASES.addInventoryItem(name, quantity, expiryDate);
	}

	/**
	 * Remove the item at the given index from the user's inventory.
	 *
	 * @param index the index of the item to be removed.
	 */
	public void removeInventoryItem(int index) {
		INVENTORY_USE_CASES.removeInventoryItem(index);
	}

	/**
	 * Return the user's shopping list that will be printed to the user.
	 *
	 * @return the user's shopping list.
	 */
	public String printShoppingList() {
		return SHOPPING_LIST_USE_CASES.returnShoppingList();
	}

	/**
	 * Add the given item (name and quantity) to the user's shopping list.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 */
	public void addShoppingListItem(String name, int quantity) {
		SHOPPING_LIST_USE_CASES.addShoppingListItem(name, quantity);
	}

	/**
	 * Remove the item at the given index from the user's shopping list.
	 *
	 * @param index the index of the item to be removed.
	 */
	public void removeShoppingListItem(int index) {
		SHOPPING_LIST_USE_CASES.removeShoppingListItem(index);
	}

	/**
	 * Save both the inventory list and the shopping list for later use.
	 */
	public void saveLists() {
		INVENTORY_USE_CASES.saveList();
		SHOPPING_LIST_USE_CASES.saveList();
	}
}
