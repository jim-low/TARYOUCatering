package adt;

import java.util.Iterator;

public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
    }

    public boolean add(T newEntry) {
        int i = 0;
        if(newEntry!=null){
            while (i < numberOfEntries && newEntry.compareTo(array[i]) < 0) {
                i++;
            }
            makeRoom(i + 1);
            array[i] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    public T search(int newIndex){
        T entry = null;
        int index = 0;
        if(!isEmpty()){
            while(index < numberOfEntries && newIndex < numberOfEntries){
                index++;
            }
            entry = array[newIndex];
        }

        return entry;
    }

    public T getLast() {
        T entry = null;
        if(!isEmpty()){
            entry = array[numberOfEntries-1];
        }
        return entry;
    }

    //ignore
    public boolean edit(int selectedIndex, T replaceEntry){
        T entry = null;
        if(!isEmpty()){
            if(selectedIndex <= numberOfEntries){

                entry = search(selectedIndex);
                array[selectedIndex] = replaceEntry;

                return true;
            }
        }
        return false;
    }

    public boolean remove(T anEntry) {
        //check if empty
        if (numberOfEntries == 0) {
            return false;
        }

        //get the right index number
        int index = 0;
        while (index < numberOfEntries) {
            if (array[index].compareTo(anEntry) == 0) {
                removeGap(index + 1);
                numberOfEntries--;
                return true;
            }
            index++;
        }
        return false;
    }

    public Iterator<T> getIterator(){
        throw new UnsupportedOperationException();
    }

    public void clear() {
        numberOfEntries = 0;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    private void doubleArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Object[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;


        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < numberOfEntries; ++i) {
            System.out.println(array[i]);
            System.out.println();
        }
    }
}
