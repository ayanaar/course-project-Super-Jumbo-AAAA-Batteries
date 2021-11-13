package use_cases;

import entities.InventoryList;
import entities.Item;
import entities.FoodItem;
import gateway.SavingManager;

import java.time.LocalDate;


/**
 * This class interacts with the inventory entities.
 */
public class InventoryUseCases implements DataHandlingUseCase {
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
	public String returnInventory() {
		return this.inventory.toString();
	}

	/**
	 * Add the given item (name, quantity, and expiry date, if applicable)
	 * to the user's inventory.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 * @param expiryDate    the expiry date of the item being added (YYYY-MM-DD).
	 */
	public void addInventoryItem(String name, int quantity, String expiryDate) {
		Item item;
		if (expiryDate.isEmpty()) {
			// Item does not have an expiry date
			item = new Item(name, quantity);
		} else {
			// Item has an expiry date
			item = new FoodItem(name, quantity, LocalDate.parse(expiryDate));
		}
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

	/**
	 * Save the inventory list to the csv file.
	 */
	public void saveList() {
		SavingManager.InventoryListSaver(this.inventory.toStringBuilder());
	}
}
