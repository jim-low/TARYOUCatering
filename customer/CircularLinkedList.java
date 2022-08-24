package customer;

import utils.Node;

/**
 * CircularLinkedList
 */
public class CircularLinkedList<T> implements CircularLinkedListInterface<T> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    public CircularLinkedList() {
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
	public void insert(T data, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean search(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}
}
