package adt;

import java.util.Iterator;

import general.Node;
import order.Order;

public class LinkedQueue<T> implements QueueInterface<T>{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numberOfEntries;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        numberOfEntries++;
        lastNode = newNode;
    }

    public T getNewNode(){
        T newNode = null;
        Node<T> currentNode = firstNode;

        while(currentNode !=null){
            newNode = currentNode.getData();
            currentNode = currentNode.getNext();
        }

      return newNode;
    }

    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.getData();
        }

        return front;
    }
    public T nextNode(){
        T node = null;
        Node<T> currentNode = firstNode;

        while(currentNode !=null){
            node = currentNode.getData();
            currentNode = currentNode.getNext();

        }

        return node;
    }

    public T listAll(){
        T node = null;

        return node;
    }


    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.getData();
            firstNode = firstNode.getNext();

            if (firstNode == null) {
                lastNode = null;
            }
        }
        numberOfEntries--;
        return front;
    } // end dequeue

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public Iterator<T> getIterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T> {

        private Node<T> currentNode;

        public LinkedQueueIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T returnData = currentNode.getData();
                currentNode = currentNode.getNext();
                return returnData;
            } else {
                return null;
            }
        }

        public boolean searchNode(T nodeEntry){
            Node<T> newNode = new Node<T>(nodeEntry);

            if(next() !=null){
                while(next().equals(newNode)){
                    return true;
                }
            }
            return false;
        }
    }
}
