package order;

import adt.LinkedQueue;
import adt.QueueInterface;
import customer.Customer;
import general.Address;
import payment.Payment;
        

import java.time.LocalDate;

public class Order {
    private String orderID;
    private Customer customerID;
    private Package packageID;
    private Payment paymentID;
    private String status;
    private Address cateringAddress;
    private LocalDate orderDate;
    private LocalDate caterDate;
    
    public Order(){
        
    }
    
    public Order(String orderID, Customer customerID, Package packageID, Payment paymentID, String status, Address cateringAddress, LocalDate orderDate, LocalDate caterDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.packageID = packageID;
        this.paymentID = paymentID;
        this.status = status;
        this.cateringAddress = cateringAddress;
        this.orderDate = orderDate;
        this.caterDate = caterDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Package getPackageID() {
        return packageID;
    }

    public void setPackageID(Package packageID) {
        this.packageID = packageID;
    }

    public Payment getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Payment paymentID) {
        this.paymentID = paymentID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getCateringAddress() {
        return cateringAddress;
    }

    public void setCateringAddress(Address cateringAddress) {
        this.cateringAddress = cateringAddress;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getCaterDate() {
        return caterDate;
    }

    public void setCaterDate(LocalDate caterDate) {
        this.caterDate = caterDate;
    }
    
    
    @Override
    public String toString() {
        return "Order: \n" + "OrderID: " + orderID + "\nCustomerID:" + customerID.getUserID() + "\nCustomerName: " + customerID.getName() + "\nCustomerPhone: " + customerID.getPhoneNum() +
            "\nPackageID: " + packageID.getPackageID() + "\nPaymentID: " + paymentID.getPaymentID() + "\nStatus:" + status +
            "\nCateringAddressLine1: " + cateringAddress.getAddressLine1() + "\nCateringAddressLine2: " + cateringAddress.getAddressLine2() +
            "\nCateringAddressLine3: " + cateringAddress.getAddressLine3() + "\nOrderDate: " + orderDate + "\nCaterDate: " + caterDate;
    }


}
