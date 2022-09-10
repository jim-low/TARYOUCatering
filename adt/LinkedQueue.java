package adt;

import java.util.Iterator;
import order.Order;

public class LinkedQueue<T> implements QueueInterface<T>{
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        numberOfEntries++;
        lastNode = newNode;
    }
    
    public T getNewNode(){
        T newNode = null;
        Node currentNode = firstNode;

        while(currentNode !=null){
            newNode = currentNode.data;
            currentNode = currentNode.next;
        }

      return newNode;
    }
  
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
        }

        return front;
    }
    public T nextNode(){
        T node = null;
        Node currentNode = firstNode;
        
        while(currentNode !=null){
            node = currentNode.data;
            currentNode = currentNode.next;
            
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
            front = firstNode.data;
            firstNode = firstNode.next;

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

        private Node currentNode;

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
                T returnData = currentNode.data;
                currentNode = currentNode.next;
                return returnData;
            } else {
                return null;
            }
        }

        public boolean searchNode(T nodeEntry){
            Node newNode = new Node(nodeEntry, null);

            if(next() !=null){
                while(next().equals(newNode)){
                    return true;
                }
            }
            return false;
        }
    }


    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
}
