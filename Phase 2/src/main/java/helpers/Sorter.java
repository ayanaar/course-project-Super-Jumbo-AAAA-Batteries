package helpers;

import java.util.List;


/**
 * Interface for sorting algorithms.
 */
public interface Sorter<T> {

    /**
     * Sort the given list.
     *
     * @param list the list being sorted.
     */
    void sort(List<T> list);
}
