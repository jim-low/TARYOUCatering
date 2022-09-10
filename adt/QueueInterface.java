package adt;

import java.util.Iterator;

public interface QueueInterface<T> {

    public void enqueue(T newEntry);

    public T dequeue();

     public Iterator<T> getIterator();
  
    public T getNewNode();
  
     public T getFront();
     
     public int totalEntries();
  
    public boolean isEmpty();

    public void clear();
    
    public T nextNode();
    
    public void listAllNode();
    
    public void editNode(T order, T replaceEntry);

}
