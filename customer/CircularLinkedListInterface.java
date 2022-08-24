package customer;

/**
 * CircularLinkedListInterface
 */
public interface CircularLinkedListInterface<T> {
    public void insert(T data); // O(1)
    public void insert(T data, int index); // O(n)

    public void remove(T data); // O(1)
    public void remove(T data, int index); // O(n)

    public boolean search(T data); // O(n)

    public int size();
}
