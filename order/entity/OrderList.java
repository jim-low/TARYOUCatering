package entity;

import adt.LinkedQueue;

public class OrderList {
    private Order orderID;
    private LinkedQueue<Staff> userIDs;

    public OrderList(Order orderID, LinkedQueue<Staff> userIDs) {
        this.orderID = orderID;
        this.userIDs = userIDs;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public LinkedQueue<Staff> getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(LinkedQueue<Staff> userIDs) {
        this.userIDs = userIDs;
    }

    @Override
    public String toString() {
        return "OrderList{" + "orderID=" + orderID + ", userIDs=" + userIDs + '}';
    }
    
    
}
