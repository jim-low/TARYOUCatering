package adt;

import java.util.Iterator;

public interface QueueInterface<T> {

  public void enqueue(T newEntry);

  public T dequeue();

  public Iterator<T> getIterator();
  
  public T getNewNode();
  
  public T getFront();

  public boolean isEmpty();

  public void clear();

}
