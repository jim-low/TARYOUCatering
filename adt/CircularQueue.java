package adt;

/**
 * CircularQueue
 */
public class CircularQueue<T> implements CircularQueueInterface<T> {
    private Node lastNode;
    
    public CircularQueue(){
        lastNode = null;
    }
    
    public void enqueue (T newEntry){
        Node newNode = new Node (newEntry, null);
        if(isEmpty()){
            newNode.next = newNode;
        }else{
            newNode.next = lastNode.next;
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }
    
    public T dequeue() {
        T front = null;
        if(!isEmpty()){
            front = getFront();
            if(lastNode.next == lastNode){
                lastNode = null;
            }else{
                lastNode.next = lastNode.next.next;
            }
        }
        
        return front;
    }

    public T getFront() {
        T frontData = null;
        if(!isEmpty()){
            frontData = lastNode.next.data;
        }
        return frontData;
    }

    public boolean isEmpty() {
        return lastNode == null;
    }
    
    public void clear(){
        if(lastNode != null){
            lastNode.next = null;
        }
        lastNode = null;
    }
    
    private class Node{
        private T data;
        private Node next;
        
        public Node(T data){
            this.data = null;
            this.next = null;
        }
        
        public Node (T data, Node anotherNode){
            this.data = data;
            this.next = anotherNode;
        }
    }
}
