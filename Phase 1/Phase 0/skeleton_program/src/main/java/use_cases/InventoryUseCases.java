package use_cases;

import entities.InventoryList;
import entities.Item;
import entities.FoodItem;


/**
 * This class interacts with the inventory entities.
 */
public class InventoryUseCases {
	private final InventoryList inventory;

	/**
	 * Initialize an empty inventory.
	 */
	public InventoryUseCases() {
		this.inventory = new InventoryList();
	}

	/**
	 * Return the user's inventory that will be printed to the user.
	 *
	 * @return the user's inventory.
	 */
	public String printInventory() {
		return this.inventory.toString();
	}

	/**
	 * Add the given item (name and quantity) to the user's inventory.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 */
	public void addInventoryItem(String name, int quantity) {
		Item item = new Item(name, quantity);
		this.inventory.addItem(item);
	}

	/**
	 * Add the given item (name, quantity, and expiry date) to the
	 * user's inventory.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 * @param expiryDate    the expiry date of the item being added.
	 */
	public void addInventoryFoodItem(String name, int quantity, int expiryDate) {
		Item item = new FoodItem(name, quantity, expiryDate);
		this.inventory.addItem(item);
	}

	/**
	 * Remove the item at the given index from the inventory.
	 *
	 * @param index the index of the item being removed.
	 */
	public void removeInventoryItem(int index) {
		this.inventory.removeItem(index);
	}
}
