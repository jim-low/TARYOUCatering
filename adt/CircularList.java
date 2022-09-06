package customer;

import general.Node;

/**
 * CircularLinkedList
 */
public class CircularList<T> implements CircularListInterface<T> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    public CircularList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void insert(T data) {
        Node<T> node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
            this.last = node;
        }
        else {
            this.last.setNext(node);
            this.last = node;
        }

        node.setNext(this.head);
        ++this.size;
    }

    @Override
    public T remove() { // remove at the head
        if (this.head == null) {
            return null;
        }

        T item = this.head.getData();

        this.head = this.head.getNext();
        this.last.setNext(this.head);
        --this.size;

        return item;
    }

    @Override
    public T remove(T data) {
        if (this.head == null) {
            return null;
        }

        if (this.size == 1) {
            return this.remove();
        }

        T item = null;
        Node<T> curr = this.head;
        Node<T> prev = null;

        while (curr.getNext() != null) {
            if (curr.getData().toString().equals(data.toString())) {
                item = curr.getData();
                break;
            }

            prev = curr;
            curr = curr.getNext();
        }

        if (item == null) {
            return null;
        }

        prev.setNext(curr.getNext());
        --this.size;

        return item;
    }

    @Override
    public boolean search(T data) {
        Node<T> curr = this.head;

        while (!curr.getNext().equals(this.head)) {
            if (curr.getData().equals(data)) {
                return true;
            }
            curr = curr.getNext();
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
