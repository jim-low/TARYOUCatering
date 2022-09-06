package order;

import general.Person;
import general.Address;
import payment.Payment;

import java.util.Date;

public class Order {
    private String orderID;
    private Person customerID;
    private Package packageID;
    private Payment paymentID;
    private String status;
    private Address cateringAddress;
    private Date orderDate;
    private Date caterDate;

    public Order(String orderID, Person customerID, Package packageID, Payment paymentID, String status, Address cateringAddress, Date orderDate, Date caterDate) {
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

    public Person getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Person customerID) {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getCaterDate() {
        return caterDate;
    }

    public void setCaterDate(Date caterDate) {
        this.caterDate = caterDate;
    }

    @Override
    public String toString() {
        return "Order: \n" + "OrderID: " + orderID + "\nCustomerID:" + customerID.getUserID() + "\nCustomerName: " + customerID.getName() + "\nCustomerPhone: " + customerID.getPhoneNum() + 
                "\nPackageID: " + packageID.getPackageID() + "\nPaymentID: " + paymentID.getPaymentID() + "\nStatus:" + status + 
                "\nCateringAddressLine1: " + cateringAddress.getAddressLine1() + "\nCateringAddressLine2: " + cateringAddress.getAddressLine2() +
                "\nCateringAddressLine3: " + cateringAddress.getAddressLine3() + "\nOrderDate:" + orderDate + "\nCaterDate: " + caterDate;
    }

    
}
