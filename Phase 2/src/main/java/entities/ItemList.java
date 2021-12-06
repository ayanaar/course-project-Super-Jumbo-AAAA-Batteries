package entities;


/**
 * Interface for a list of items.
 */
public interface ItemList {

    /**
     * Return the number of items in this list.
     *
     * @return the number of items in this list.
     */
    int getSize();

    /**
     * Return the item at the given index.
     *
     * @param index the index of the item in this list.
     * @return the item at the given index.
     */
    Item getItem(int index);

    /**
     * Add the given item to this list.
     *
     * @param item the item being added.
     */
    void addItem(Item item);

    /**
     * Remove the item at the given index.
     *
     * @param index the index of the item in this list.
     */
    void removeItem(int index);
}
