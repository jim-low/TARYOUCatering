package adt;

import java.util.Iterator;

import general.Node;

public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T> {
    //remember to add validations for your ADTs, other validations that are not related to ADTs are not required.
    private Node<T> firstNode;
    private int numberOfEntries;

    public SortedLinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    //add an entry, return true if successful.
    public boolean add(T newEntry) {

        Node<T> newNode = new Node<T>(newEntry);

        Node<T> nodeBefore = null;
        Node<T> currentNode = firstNode;
        while (currentNode != null && newEntry.compareTo((T)currentNode.getData()) > 0) {
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

        // what is all this??????????????????????
        // Sincerely, Jim

        /*REFERENCE (list based on date (ignore tq))
          Node<T> newNode = new Node<T>(newEntry); //create a newNode object to determine the node you want to add.

          Node<T> nBefore = null; //variable for the node before
          Node<T> nCurrent = firstNode; //variable for the current node (currently set to the first position)

        //initializaing obj
        Payment paymentToAdd = (Payment)newEntry; // assume the node to be added is a payment object
        Date dateEntry = paymentToAdd.getPaymentDate(); //get the newEntry's Date ( assumed to be a Payment object.)
        Payment paymentToCompare = (Payment)firstNode.getData();
        Date dateToCompare = paymentToCompare.getPaymentDate();

        //for REF onlyc(NODE CLASS)
        //private T data;
        //private Node<T><T> next;
        //private Node<T><T> prev;

        //if the current node is not null, and the spesified entry's date is later than the nCurrent's Date
        while (nCurrent != null && dateEntry.compareTo((dateToCompare)) > 0){ //continue to loop it
        nBefore = nCurrent; // The current node will be the node before it
        nCurrent = nCurrent.getNext(); //the current node's next node will be the current node
        //imagine the loop like this
        // [D1] -> (D2) -> D3 -> D4
        //to
        // D1 -> [D2] -> (D3) -> D4 (and so on...)
        //REINITIALIZE dateToCompare
        paymentToCompare = (Payment)nCurrent.getData(); //change the payment object to the next payment object in the array.
        dateToCompare = paymentToCompare.getPaymentDate(); //reinitialize dateToCompare with the new next Payment Object
        }

        //if the array is empty
        if (isEmpty() || (nBefore == null)) {
        newNode.setNext(firstNode); //the newNode will be set as the first node
        firstNode = newNode; //initialize the first Node<T> in the list with the new node
        }

        //if it's not empty
        else {
        newNode.setNext(nCurrent); //the newNode's nextNode will be the nCurrent (assuming it should be newNode is earlier than currentNode)
        nBefore.setNext(newNode); //nBefore's nextNode will be set to the newNode.
        //imagine it like this
        // 1 -> 3(nBefore) -> 5(nCurrent) (to add: 4 (newNode))
        //to
        // 1 -> 3 -> 4(nBefore.setNext(newNode)) -> 5(newNode.setNext)
        }
        numberOfEntries++; //increase the number of entries.
        return true;
        */
    }

    //remove a specified entry, return true if successful.
    public boolean remove(T anEntry) {
        if (firstNode == null) {
            return false;
        } else {
            int count = 0;
            Node<T> beforeNode = null;
            Node<T> currentNode = firstNode;

            while (currentNode != null && !currentNode.getData().toString().equals(anEntry.toString())) {
                System.out.println(anEntry); //test
                System.out.println(currentNode.getData()); //test
                System.out.println("can't find anything! Next!"); //test
                beforeNode = currentNode;
                currentNode = currentNode.getNext();
                count++;
            }

            System.out.println(beforeNode.getData()); //test (WARNING: beforeNode is Null.)
            System.out.println(currentNode.getData()); //test

            //if target is not found.
            if (currentNode == null) {
                return false;
            }

            //if the first record is the one to be removed...(WIP)
            if (beforeNode == null) {
                Node<T> temp = currentNode; //ignore
                currentNode.setNext(currentNode.getNext()); //ignore
                //currentNode = currentNode.getNext();
                numberOfEntries--;
                return true;
            }

            //if target is found
            if (currentNode.getData().toString().equals(anEntry.toString())) {
                beforeNode.setNext(currentNode.getNext());
                currentNode = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;

    }


    //search if there is the spesified entry is in the list, otherwise, return false.
    public boolean contains(T anEntry) {
        boolean found = false;
        Node<T> tempNode = firstNode;

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
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    //get how many total entries are in the list.
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public Iterator<T> getIterator() {
        return new ListIterator();
    }

    //for getIterator function
    private class ListIterator implements Iterator<T> {
        private Node<T> currentNode = firstNode;

        public boolean hasNext() {
            return currentNode != null;
        }

        public T next() { //return the node's data (like going thru the next index (not actually index but smth like that.))
            T currentData = null;
            if (hasNext()) {
                currentData = (T)currentNode.getData();
                currentNode = currentNode.getNext();
            }
            return currentData;
        }
    }


    public String toString() {
        String outputStr = "";
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.getData() + "\n";;
            currentNode = currentNode.getNext();
        }
        return outputStr;
    }

    //check if the array is empty, return true if it is empty.
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

}
