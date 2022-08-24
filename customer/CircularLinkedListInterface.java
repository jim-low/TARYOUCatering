package customer;

/**
 * CircularLinkedListInterface
 */
public interface CircularLinkedListInterface<T> {
    public void insert(T data); // inserts new data to the beginning or at the end -> O(1)
    public void insert(T data, int index); // inserts new data to a specified index location -> O(n)

    public void remove(T data); // removes data at the head -> O(1)
    public void remove(T data, int index); // removes data at a specified index location -> O(n)

    public boolean search(T data); // determines whether the given data exists in the list -> O(n)

    public int size();
}
