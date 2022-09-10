package adt;
//refer to lecture slides, Appendix 7.1 Sorted List Implementation

import java.util.Iterator;

public interface SortedListInterface<T extends Comparable<T>> {

    public boolean add(T newEntry); //add an entry, return true if successful.

    public boolean remove(T anEntry); //remove a specified entry, return true if successful.

    public boolean edit(int selectedIndex, T replaceEntry);

    public boolean contains(T anEntry); //search if there is the spesified entry is in the list, otherwise, return false.

    public void clear(); //remove all entries from the list.

    public int getNumberOfEntries(); //get how many total entries are in the list.

    public boolean isEmpty(); //check if the array is empty, return true if it is empty.

    public Iterator<T> getIterator();

    public T search(int index);
    
    public T getLast();
}
