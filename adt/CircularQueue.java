package adt;


import general.Node;



/**
 * CircularQueue
 */
public class CircularQueue<T> implements CircularQueueInterface<T> {
    private Node<T> lastNode;
    private int size;

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
        ++this.size;
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
        --this.size;
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
        --this.size;
    }
    
    public T search(T data){
        //if search parameter is null
        if(this.lastNode == null){
            return null;
        }else{
            
            Node<T> curr = this.lastNode;
            
            for(int i = 0; i < this.size; i++){
                System.out.println("Searching");
                if (curr.getData().compareTo(data) == 0){
                    return curr.getData();
                }
                curr.setNext(curr.getNext());
            }
            return null;
        }
    }
}
