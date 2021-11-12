package use_cases;

// Interface for InventoryLists and ShoppingLists that can save data to the database.
interface DataHandlingUseCase {
    public void saveList(); // Interface method for saving the current state of the list.
}