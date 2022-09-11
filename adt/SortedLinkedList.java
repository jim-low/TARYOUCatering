package adt;

//DO NOT use any predefined collection interfaces and classes from the Java Collections Framework.
import java.util.Date;
import payment.Payment;
import general.Node;
import java.util.Iterator;
import adt.SortedListInterface;

public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T> {
    //remember to add validations for your ADTs, other validations that are not related to ADTs are not required.
    private Node firstNode;
    private int numberOfEntries;

    public SortedLinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    //add an entry, return true if successful.
    public boolean add(T newEntry){

        Node<T> newNode = new Node<T>(newEntry);

        Node<T> nodeBefore = null;
        Node<T> currentNode = firstNode;

        while (currentNode != null && newEntry.compareTo(currentNode.getData()) > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNext();
        }

        if (isEmpty() || (nodeBefore == null)) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }

        else {
            newNode.setNext(currentNode);
            nodeBefore.setNext(newNode);
        }
        numberOfEntries++;
        return true;
    }

    //remove a specified entry, return true if successful.

    public boolean remove(T anEntry){

        //is empty
        if(firstNode == null){
            return false;
        }

        else{
            int count = 0;

            Node<T> beforeNode = null;
            Node<T> currentNode = firstNode;
            int listIndex = 0;
            while (currentNode != null){ //loop until the end

                if(currentNode.getData().compareTo(anEntry) == 0){ //found the matching record

                    if(currentNode.equals(firstNode)){ //does it match with the first node?
                        firstNode = currentNode.getNext();
                    }

                    else if (listIndex == numberOfEntries - 1){ //does it match with the last node?
                        beforeNode.setNext(null);
                    }

                    else{ //does it match anywhere other than the last or first node?
                        beforeNode.setNext(currentNode.getNext());
                    }

                    numberOfEntries--;
                    return true;
                }

                beforeNode = currentNode;
                currentNode = currentNode.getNext();
                ++listIndex;
            }


        }
        return false;

    }


    //search if there is the spesified entry is in the list, otherwise, return false.
    public boolean contains(T anEntry){
        boolean found = false;
        Node tempNode = firstNode;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo((T)tempNode.getData()) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.getNext();
            }
        }

        if (tempNode != null && tempNode.getData().toString().equals(anEntry.toString())) {
            return true;
        }

        else {
            return false;
        }
    }

    //remove all entries from the list.
    public void clear(){
        firstNode = null;
        numberOfEntries = 0;
    }

    //get how many total entries are in the list.
    public int getNumberOfEntries(){
        return numberOfEntries;
    }

    public Iterator<T> getIterator(){
        return new ListIterator();
    }

    @Override
    public T search(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getLast() {
        Node<T> currentNode = firstNode;

        if (currentNode == null){
            return null;
        }

        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }

        return currentNode.getData();
    }

    public boolean edit(int selectedIndex, T replaceEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //for getIterator function
    private class ListIterator implements Iterator<T>{
        //private int index=0 "start with the first item"
        private Node currentNode = firstNode;

        public boolean hasNext(){
            return currentNode != null;
        }

        public T next(){ //return the node's data (like going thru the next index (not actually index but smth like that.))
            T currentData = null;
            if (hasNext()){
                currentData = (T)currentNode.getData();
                currentNode = currentNode.getNext();
            }
            return currentData;
        }
    }


    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.getData() + "\n";;
            currentNode = currentNode.getNext();
        }
        return outputStr;
    }

    //check if the array is empty, return true if it is empty.
    public boolean isEmpty(){
        return (numberOfEntries == 0);
    }

	@Override
	public void display() {
        Node<T> currNode = firstNode;
        while (currNode != null) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
        }
	}
}
