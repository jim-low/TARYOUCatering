package adt;


import general.Node;



/**
 * CircularQueue
 */
public class CircularQueue<T> implements CircularQueueInterface<T> {
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
}
