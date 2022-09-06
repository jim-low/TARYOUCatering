package adt;

/**
 * CircularListInterface
 */
public interface CircularListInterface<T> {
    public void insert(T data); // inserts new data to the beginning or at the end -> O(1)
    public T remove(); // removes data at the head -> O(1)
    public T remove(T data); // removes data at the head -> O(1)
    public T search(T data); // determines whether the given data exists in the list -> O(n)
    public int size();
}
