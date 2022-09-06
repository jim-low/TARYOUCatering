package payment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Payment implements Comparable<Payment>{

    String paymentID;
    double paymentAmt;
    LocalDate paymentDate;
    String paymentMethod;
    //CircularLinkedList<Order> totalPayments; //assume this is an array.

    public Payment(String paymentID, double paymentAmt, LocalDate paymentDate, String paymentMethod) {
        this.paymentID = paymentID;
        this.paymentAmt = paymentAmt;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
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

    //do not add functions that receive input or display output.

    public Payment searchPayment(String id){

        if (this.paymentID.equals(id)){
            Payment foundPayment = new Payment(this.paymentID, this.paymentAmt, this.paymentDate, this.paymentMethod);
            //return the matched object
            return foundPayment;
        }

        else return null;

    }

    @Override
    public String toString() {
        return "paymentID = " + paymentID + ", paymentAmt = " + paymentAmt + ", paymentDate = " + paymentDate + ", paymentMethod = " + paymentMethod;
    }

    @Override
    public int compareTo(Payment p) { //compare using ID, assuming (Letters)(Numbers) (try to compare using date)
        String[] numToCompare = p.paymentID.split("[a-zA-Z]+");
        String[] currentNum = this.paymentID.split("[a-zA-Z]+");
        return Integer.parseInt(currentNum[1]) - Integer.parseInt(numToCompare[1]);
        
        //try to compare using dates
        //LocalDate dateToCompare = p.getPaymentDate();
        //LocalDate currentPDate
    }

}


