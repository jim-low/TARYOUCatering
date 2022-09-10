package adt;


import general.Node;
import java.util.Iterator;



/**
 * CircularQueue
 */
public class CircularQueue<T extends Comparable<T>> implements CircularQueueInterface<T> {
    private Node<T> lastNode;

    public CircularQueue(){
        lastNode = null;
    }

    public void enqueue (T newEntry){
        Node<T> newNode = new Node<T> (newEntry);
        if(isEmpty()){
            newNode.setNext(newNode);
        }else{
            //            newNode.next = lastNode.next;
            newNode.setNext(lastNode.getNext());
            //            lastNode.next = newNode;
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    public T dequeue() {
        T front = null;
        if(!isEmpty()){
            front = getFront();
            if(lastNode.getNext() == lastNode){
                lastNode = null;
            }else{
                //                lastNode.next = lastNode.next.next;
                lastNode.setNext(lastNode.getNext().getNext());
            }
        }
        return front;
    }

    public T getFront() {
        T frontData = null;
        if(!isEmpty()){
            //            frontData = lastNode.next.data;
            frontData = lastNode.getNext().getData();
        }
        return frontData;
    }

    public boolean isEmpty() {
        return lastNode == null;
    }

    public void clear(){
        if(lastNode != null){
            lastNode.setNext(null);
        }
        lastNode = null;
    }
    
    public Iterator<T> getIterator(){
        return new CircularQueueIterator();
    }

    @Override
    public T search(T data) {
        if(lastNode == null){
            return null;
        }
        
        Node<T> curr = lastNode.getNext();
        
        while(curr != lastNode){
            if(curr.getData().compareTo(data) == 0){
                return curr.getData();
            }
            curr = (curr.getNext());
        }
        return null;
    }

    private class CircularQueueIterator implements Iterator<T>{
        private Node<T> currentNode;
        
        public CircularQueueIterator() {
            currentNode = lastNode.getNext();
        }
        
        public boolean hasNext(){
            return currentNode!= null;
        }
        
        @Override
        public T next(){
            T currentData = null;
            if(hasNext()){
                currentData = currentNode.getData();
                currentNode = currentNode.getNext();
                return currentData;
            }else{
                return null;
            }
        }
    }
}
