package helpers;

import java.util.Collections;
import java.util.List;


/**
 * Class for implementing the TimSort algorithm.
 *
 */
public class TimSorter<T extends Comparable<T>> implements Sorter<T> {

    /**
     * Sort the given list using the TimSort algorithm.
     *
     * @param list the list being sorted.
     */
    public void sort(List<T> list) {
        Collections.sort(list);
    }
}
