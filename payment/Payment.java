package payment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import order.Order;

public class Payment implements Comparable<Payment>{

    String paymentID;
    double paymentAmt;
    LocalDate paymentDate;
    String paymentMethod;
    Order order;
    //CircularLinkedList<Order> totalPayments; //assume this is an array.

    

    public Payment(String paymentID, double paymentAmt, LocalDate paymentDate, String paymentMethod, Order order) {
        this.paymentID = paymentID;
        this.paymentAmt = paymentAmt;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.order = order;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    //do not add functions that receive input or display output.

    public Payment searchPayment(String id){

        if (this.paymentID.equals(id)){
            Payment foundPayment = new Payment(this.paymentID, this.paymentAmt, this.paymentDate, this.paymentMethod, this.order);
            //return the matched object
            return foundPayment;
        }

        else return null;

    }

    @Override
    public String toString() {
        return "paymentID = " + paymentID + String.format(" , paymentAmt = %.2f", paymentAmt) + ", paymentDate = " + paymentDate + ", paymentMethod = " + paymentMethod + "CaterDate = " + order.getCaterDate();
    }

    @Override
    public int compareTo(Payment p) { 
        //if comparing using id
        //String[] numToCompare = p.paymentID.split("[a-zA-Z]+");
        //String[] currentNum = this.paymentID.split("[a-zA-Z]+");
        //return Integer.parseInt(currentNum[1]) - Integer.parseInt(numToCompare[1]);
        
        //compare using cater dates
        LocalDate dateToCompare = p.order.getCaterDate();
        LocalDate currentPDate = this.order.getCaterDate();
        int dateCompareValue = currentPDate.compareTo(dateToCompare);
        return dateCompareValue;
    }

}