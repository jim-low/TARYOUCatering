package customer;

/**
 * CircularLinkedList
 */
public class CircularLinkedList<T> implements CircularLinkedListInterface<T> {
    private T head;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }
}
