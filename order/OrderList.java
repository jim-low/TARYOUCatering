package order;

import staff.Staff;

import adt.LinkedQueue;

public class OrderList {
    private Order orderID;
    private String[] staffIDs;

    public OrderList(Order orderID, String[] staffIDs) {
        this.orderID = orderID;
        this.staffIDs = staffIDs;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public String[] getStaffIDs() {
        return staffIDs;
    }

    public void setStaffIDs(String[] staffIDs) {
        this.staffIDs = staffIDs;
    }

    
}
