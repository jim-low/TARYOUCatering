package customer;

import utils.Node;

/**
 * CircularLinkedList
 */
public class CircularLinkedList<T> implements CircularLinkedListInterface<T> {
    private Node<T> head;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }
}
