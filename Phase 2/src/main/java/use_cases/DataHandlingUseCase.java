package use_cases;

/**
 * Interface for InventoryLists and ShoppingLists that can save data to the database.
 */
interface DataHandlingUseCase {

    /**
     * This method is for saving the current state of the list.
     */
    void saveList(String user);
}