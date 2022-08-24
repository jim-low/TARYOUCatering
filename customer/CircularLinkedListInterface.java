package customer;

/**
 * CircularLinkedListInterface
 */
public interface CircularLinkedListInterface<T> {
    public void insert(T data); // inserts new data to the beginning or at the end -> O(1)
    public T remove(); // removes data at the head -> O(1)
    public boolean search(T data); // determines whether the given data exists in the list -> O(n)
    public int size();
}
