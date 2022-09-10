package adt;

import java.util.Iterator;

public interface CircularQueueInterface<T> {
    public void enqueue(T newEntry);
    public T dequeue();
    public T getFront();
    public boolean isEmpty();
    public void clear();
    public Iterator<T> getIterator();
    public T search(T data);
}
